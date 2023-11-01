package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cria camada de controller da rota '/fertilizers'.
 *
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizersController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizersController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * IMplementa de cadastros de fertilizantes.
   *
   * @param fertilizerDto um fertilizante com name, brand e composition.
   * @return o cadastro criado.
   */
  @PostMapping
  public ResponseEntity<Fertilizer> postCreateFertilizers(@RequestBody
      FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerService.createNewFertilizer(fertilizerDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(fertilizer);
  }

  @GetMapping
  public  ResponseEntity<List<Fertilizer>> getAllFertilizers() {
    List<Fertilizer> fertilizer = fertilizerService.findAllFertilizer();
    return ResponseEntity.status(HttpStatus.OK).body(fertilizer);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable Long id) {
    Fertilizer fertilizer = fertilizerService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(fertilizer);
  }
}
