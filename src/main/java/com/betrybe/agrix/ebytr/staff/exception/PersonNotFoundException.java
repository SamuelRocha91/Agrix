package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Person not found exception.
   *
   * @param message the message
   */
  public PersonNotFoundException(String message) {
    super(message);
  }

}
