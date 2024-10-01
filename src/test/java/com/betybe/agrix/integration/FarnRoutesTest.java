package com.betybe.agrix.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import com.betrybe.agrix.ebytr.staff.model.entity.Farm;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.model.repository.FarmRepository;
import com.betrybe.agrix.ebytr.staff.model.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.TokenService;
import java.time.LocalDate;
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


@AutoConfigureMockMvc
@Testcontainers
@SpringBootTest(classes = AgrixApplication.class)
public class FarnRoutesTest {
  @Autowired
  MockMvc mockMvc;

  /**
   * The Person repository.
   */
  @Autowired
  FarmRepository farmRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  TokenService tokenService;

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

  private void createPerson() {
    Person person = new Person();
    person.setUsername("Samuel");
    person.setRole(Role.ADMIN);
    String hashPassword = new BCryptPasswordEncoder().encode("12345678");
    person.setPassword(hashPassword);

    personRepository.save(person);
  }

  private Crop createCrop() {
    Crop crop = new Crop();
    crop.setHavestDate(LocalDate.parse("2023-12-25"));
    crop.setPlantedDate(LocalDate.parse(("2023-05-12")));
    crop.setPlantedArea(4.50);
    crop.setName("Macarrao");
    return crop;
  }

  private String generateToken() {
    return tokenService.generateToken("Samuel");
  }

  private void persistFarms() {
    Farm farm = new Farm();
    farm.setName("abc");
    farm.setSize(4.55);
    farmRepository.save(farm);
  }

  @Test
  public void testGetAllFarms() throws Exception {
    createPerson();
    String token = generateToken();
    persistFarms();

    mockMvc.perform(get("/farms")
        .accept(MediaType.APPLICATION_JSON)
        .header("Authorization", "Bearer " + token)  // Adiciona o token Bearer no header
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("abc"))
        .andExpect(jsonPath("$[0].size").value(4.55));
  }

  @Test
  public void testGetFarmById() throws Exception {
    createPerson();
    String token = generateToken();
    persistFarms();

    mockMvc.perform(get("/farms/1")
            .accept(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("abc"))
        .andExpect(jsonPath("$.size").value(4.55));
  }

  @Test
  public void testFarmNotFound() throws Exception {
    createPerson();
    String token = generateToken();
    persistFarms();

    mockMvc.perform(get("/farms/2")
            .accept(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$").value("Fazenda não encontrada!"));
  }

  @Test
  public void testCreateFarm() throws Exception {
    String token = generateToken();
    createPerson();
    mockMvc.perform(post("/farms")
        .accept(MediaType.APPLICATION_JSON)
        .header("Authorization", "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"Szfr\",\"size\":\"1234.50\"}"))
        .andExpect(status().isCreated());
  }

  @Test
  public void testCreateCropToFarm() throws Exception {
    String token = generateToken();
    createPerson();
    persistFarms();

    mockMvc.perform(post("/farms/1/crops")
            .accept(MediaType.APPLICATION_JSON)
            .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"Szfr\",\"PlantedArea\":\"1234.50\"}"))
        .andExpect(status().isCreated());
  }
}
