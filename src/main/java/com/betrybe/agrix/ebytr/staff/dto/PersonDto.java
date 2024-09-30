package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Person;

/**
 * The type Person dto.
 */
public record PersonDto(Long id, String username, String role) {

  /**
   * Entity from dto person dto.
   *
   * @param person the person
   * @return the person dto
   */
  public static PersonDto entityFromDto(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }

}
