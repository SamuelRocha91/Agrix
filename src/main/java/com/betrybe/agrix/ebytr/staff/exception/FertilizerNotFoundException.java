package com.betrybe.agrix.ebytr.staff.exception;

/**
 * cria uma runtimeexception pela ausencia de dado fertilizante no repository.
 */
public class FertilizerNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Fertilizer not found exception.
   *
   * @param message the message
   */
  public FertilizerNotFoundException(String message) {
    super(message);
  }
}
