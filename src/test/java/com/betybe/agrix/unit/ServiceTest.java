package com.betybe.agrix.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.model.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = AgrixApplication.class)
@ActiveProfiles("test")
public class ServiceTest {

  @MockBean
  PersonRepository personRepository;

  @Autowired
  PersonService personService;

  private Person createDefaultPerson() {
    Person person = new Person();
    person.setPassword("12345678");
    person.setUsername("Samuel");
    person.setRole(Role.ADMIN);
    return person;
  }

  private Person createDefaultPersonWithId(Long id) {
    Person person = createDefaultPerson();
    person.setId(id);
    return person;
  }


  @Test
  public void testPersonCreation() {
    Person person = createDefaultPerson();

    Person personToReturn = createDefaultPersonWithId(123L);

    Mockito.when(personRepository.save(any())).thenReturn(personToReturn);

    Person person1 = personService.create(person);

    Mockito.verify(personRepository).save(any());

    assertEquals(123L, person1.getId());
    assertEquals(person1.getRole(), personToReturn.getRole());
    assertEquals(person1.getUsername(), personToReturn.getUsername());
  }

  @Test
  public void testSearchPersonById() {
    Person person = createDefaultPerson();

    Person personToReturn = createDefaultPersonWithId(123L);

    Mockito.when(personRepository.findById(eq(123L)))
        .thenReturn(Optional.of(personToReturn));

    Person person1 = personService.getPersonById(123L);

    Mockito.verify(personRepository).findById(eq(123L));

    assertEquals(123L, person1.getId());
    assertEquals(person1.getRole(), personToReturn.getRole());
    assertEquals(person1.getUsername(), personToReturn.getUsername());
  }

  @Test
  public void testSearchPersonByUsername() {
    Person person = createDefaultPerson();

    Person personToReturn = createDefaultPersonWithId(123L);

    Mockito.when(personRepository.findByUsername(eq("Samuel")))
        .thenReturn(Optional.of(personToReturn));

    Person person1 = personService.getPersonByUsername("Samuel");

    Mockito.verify(personRepository).findByUsername(eq("Samuel"));

    assertEquals(123L, person1.getId());
    assertEquals(person1.getRole(), personToReturn.getRole());
    assertEquals(person1.getUsername(), personToReturn.getUsername());
  }

  @Test
  public void testPersonNotFound() {
    Mockito.when(personRepository.findByUsername(any()))
        .thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("Samuel"));

    Mockito.verify(personRepository).findByUsername(eq("Samuel"));
  }

  @Test
  public void testPersonNotFoundByUsername() {
    Mockito.when(personRepository.findByUsername(any()))
        .thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("Samuel"));

    Mockito.verify(personRepository).findByUsername(eq("Samuel"));
  }
}
