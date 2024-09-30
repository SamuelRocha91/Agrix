package com.betrybe.agrix.ebytr.staff.advice;

import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * classe responsável por tratar os erros lançados e responder ao cliente.
 *
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handle farm not found response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler({
      FarmNotFoundException.class,
      CropNotFoundException.class,
      FertilizerNotFoundException.class,
      PersonNotFoundException.class
  })
  public ResponseEntity<String> handleFarmNotFound(Exception exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}
