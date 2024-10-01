package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The type Person creation dto.
 */
public record PersonCreationDto(
    @NotBlank(message = "username is Required")
    String username,

    @Size(min = 6, message = "Password must have at least 6 characters")
    @NotBlank(message = "Password is Required")
    String password,

    Role role) {

  /**
   * From entity person.
   *
   * @return the person
   */
  public Person fromEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
