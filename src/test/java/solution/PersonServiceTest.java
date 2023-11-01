package solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


@DisplayName("Testes da camada Service da entidade Person")
@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

  @Autowired
  PersonService personService;

  @MockBean
  PersonRepository personRepository;

  @Test
  @DisplayName("Testa busca com sucesso de pessoa por Id")
  public void testPersonByIdWithSucess() {
    Role role = Role.USER;
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Vitória");
    person.setPassword("1234567");
    person.setRole(role);

    Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(person));

    Person personById = personService.getPersonById(1L);

    assertEquals(personById.getId(), person.getId());
    assertEquals(personById.getPassword(), person.getPassword());
    assertEquals(personById.getUsername(), person.getUsername());
    assertEquals(personById.getRole(), person.getRole());

    Mockito.verify(personRepository).findById(any());
  }

  @Test
  @DisplayName("Testa se é lançado erro quando a busca retorna vazia")
  public void testPersonByIdWithException() {

    Mockito.when(personRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(2L));

    Mockito.verify(personRepository).findById(any());
  }

  @Test
  @DisplayName("Testa busca com sucesso de pessoa por name")
  public void testPersonByNameWithSucess() {
    Role role = Role.USER;
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Vitória");
    person.setPassword("1234567");
    person.setRole(role);

    Mockito.when(personRepository.findByUsername(any())).thenReturn(Optional.of(person));

    Person personById = personService.getPersonByUsername(any());

    assertEquals(personById.getId(), person.getId());
    assertEquals(personById.getPassword(), person.getPassword());
    assertEquals(personById.getUsername(), person.getUsername());
    assertEquals(personById.getRole(), person.getRole());

    Mockito.verify(personRepository).findByUsername(any());
  }

  @Test
  @DisplayName("Testa se é lançado erro quando a busca por Name retorna vazia")
  public void testPersonByNameWithException() {

    Mockito.when(personRepository.findByUsername(any())).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername(any()));

    Mockito.verify(personRepository).findByUsername(any());
  }

  @Test
  @DisplayName("Testa se a service envia e recebe dados de confirmação de Person criada")
  public void testCreatePerson() {
    Role role = Role.USER;
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Vitória");
    person.setPassword("1234567");
    person.setRole(role);

    Mockito.when(personRepository.save(person)).thenReturn(person);

    Person personById = personService.create(person);

    assertEquals(personById.getId(), person.getId());
    assertEquals(personById.getPassword(), person.getPassword());
    assertEquals(personById.getUsername(), person.getUsername());
    assertEquals(personById.getRole(), person.getRole());

    Mockito.verify(personRepository).save(any());
  }
}
