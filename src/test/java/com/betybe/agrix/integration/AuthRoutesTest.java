package com.betybe.agrix.integration;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.model.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.jayway.jsonpath.JsonPath;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * The type Auth routes test.
 */
@AutoConfigureMockMvc
@Testcontainers
@SpringBootTest(classes = AgrixApplication.class)
public class AuthRoutesTest {

  /**
   * The Mock mvc.
   */
  @Autowired
  MockMvc mockMvc;

  /**
   * The Person repository.
   */
  @Autowired
  PersonRepository personRepository;

  /**
   * The constant MYSQL_CONTAINER.
   */
  @Container
  public static MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:8.0.32")
      .withDatabaseName("agrixDb");

  /**
   * Override properties.
   *
   * @param registry the registry
   */
  @DynamicPropertySource
  public static void overrideProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
    registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
  }

  /**
   * Test person creation.
   *
   * @throws Exception the exception
   */
  @Test
  public void testPersonCreation() throws Exception {
    String personUrl = "/auth/login";
    Person person = new Person();
    person.setUsername("Samuel");
    person.setRole(Role.ADMIN);
    String hashPassword = new BCryptPasswordEncoder().encode("12345678");
    person.setPassword(hashPassword);

    personRepository.save(person);

    mockMvc.perform(post(personUrl)
            .accept(MediaType.APPLICATION_JSON)
            .content("{\"username\":\"Samuel\",\"password\":\"12345678\"}")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").exists())  // Verifica que o token existe
        .andExpect(jsonPath("$.token").isNotEmpty())
        .andDo(result -> {
          String jsonResponse = result.getResponse().getContentAsString();
          String token = JsonPath.read(jsonResponse, "$.token");

          assertTrue(token.split("\\.").length == 3, "Token não está no formato JWT");

          String[] tokenParts = token.split("\\.");
          String payload = new String(Base64.getDecoder().decode(tokenParts[1]));
          System.out.println(payload);
          assertTrue(payload.contains("\"sub\":\"Samuel\""), "Token não contém o nome de usuário correto");
        });;
  }

}
