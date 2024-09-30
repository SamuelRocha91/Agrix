package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Erro customizado lançado pela inexistÇencia de cadastro de uma dada fazenda.
 */
public class FarmNotFoundException extends RuntimeException {


  /**
   * Instantiates a new Farm not found exception.
   *
   * @param message the message
   */
  public FarmNotFoundException(String message) {
    super(message);
  }
}
