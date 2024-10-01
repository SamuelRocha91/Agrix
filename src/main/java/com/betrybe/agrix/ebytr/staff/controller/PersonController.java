package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param service the service
   */
  @Autowired
  public PersonController(PersonService service) {
    this.personService = service;
  }

  /**
   * Post person response entity.
   *
   * @param personDto the person dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<PersonDto> postPerson(@Valid @RequestBody PersonCreationDto personDto) {
    Person person = personService.create(personDto.fromEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(PersonDto.entityFromDto(person));
  }
}