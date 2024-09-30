package com.betrybe.agrix.ebytr.staff.exception;

/**
 * lança uma exeção por não encontrar uma plantação.
 */
public class CropNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Crop not found exception.
   *
   * @param message the message
   */
  public CropNotFoundException(String message) {
    super(message);
  }
}
