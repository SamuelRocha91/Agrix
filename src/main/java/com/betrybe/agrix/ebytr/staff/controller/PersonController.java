package com.betrybe.agrix.ebytr.staff.controller;

// src/main/java/com/betrybe/trybetrack/controllers/AuthenticationController.java

import com.betrybe.agrix.ebytr.staff.dto.AuthenticationDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDtoResponse;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa controller de autorização e autenticação.
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {


  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * cria rota de cadastro de usuário.
   *
   * @param personDto com username, password e role.
   * @return id, username e role.
   */
  @PostMapping()
  public ResponseEntity<PersonDtoResponse> register(@RequestBody PersonDto personDto) {
    Person person = personService.create(personDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(new PersonDtoResponse(person.getId(),
        person.getUsername(), person.getRole()));
  }


}