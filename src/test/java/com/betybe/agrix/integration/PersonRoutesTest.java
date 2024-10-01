package com.betybe.agrix.integration;

import com.betrybe.agrix.AgrixApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.betrybe.agrix.ebytr.staff.model.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@Testcontainers
@SpringBootTest(classes = AgrixApplication.class)
public class PersonRoutesTest {
  @Autowired
  PersonRepository personRepository;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;


  @Container
  public static MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:8.0.32")
      .withDatabaseName("agrixDb");

  @DynamicPropertySource
  public static void overrideProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
    registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
  }

  @Test
  public void testPersonCreation() throws Exception {
    String personUrl = "/persons";

    mockMvc.perform(post(personUrl)
        .accept(MediaType.APPLICATION_JSON)
            .content("{\"username\":\"Samuel\",\"password\":\"12345678\",\"role\":\"ADMIN\"}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.username").value("Samuel"))
        .andExpect(jsonPath("$.role").value("ROLE_ADMIN"));
  }

}
