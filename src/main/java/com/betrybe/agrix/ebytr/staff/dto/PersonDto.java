package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Dto de recebimento de dados sobre cadastro.
 *
 * @param username String.
 * @param password String.
 * @param role autorização.
 */
public record PersonDto(String username, String password, Role role) {

  /**
   * converte de dto pra entidade.
   *
   * @return.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
