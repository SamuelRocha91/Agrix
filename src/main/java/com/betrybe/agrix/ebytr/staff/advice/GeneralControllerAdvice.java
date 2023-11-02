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
   * Método que trata o lançamento de uma exceção de fazenda não encontrada pelo id.
   *
   * @param farmNotFoundException excecao lançada no farmSercide.
   * @return 404 e uma mensagem.
   */
  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleFarmNotFoundException(FarmNotFoundException
      farmNotFoundException) {
    Exception exception1 = new Exception("Fazenda não encontrada!");
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception1.getMessage());
  }

  /**
   * trata a exceção por crop not found.
   *
   * @param cropNotFoundException a exceção lançada na service de crop.
   * @return um status  com uma mensagem.
   */
  @ExceptionHandler(CropNotFoundException.class)
  public ResponseEntity<String> handleCropNotFoundException(CropNotFoundException
      cropNotFoundException) {
    Exception exception1 = new Exception("Plantação não encontrada!");
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception1.getMessage());
  }

  /**
   * cria uma escuta para resposta ao usuário por fertilizante
   * inxistente no banco de dados.
   *
   * @return uma resposta ao cliente.
   **/
  @ExceptionHandler(FertilizerNotFoundException.class)
  public ResponseEntity<String> handleRunTimeException(FertilizerNotFoundException e) {
    Exception exception1 = new Exception("Fertilizante não encontrado!");
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception1.getMessage());
  }

  /**
   * cria escuta de exceção por person not found.
   *
   * @param personNotFoundException runtime.
   * @return httpresponse.
   */
  @ExceptionHandler(PersonNotFoundException.class)
  public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException
      personNotFoundException) {
    Exception exception1 = new Exception("Pessoa não encontrada!");
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception1.getMessage());
  }
}
