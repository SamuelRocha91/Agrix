package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Fertilizer controller.
   *
   * @param service the service
   */
  @Autowired
  public FertilizerController(FertilizerService service) {
    this.fertilizerService = service;
  }

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  @Secured("ROLE_ADMIN")
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers(@AuthenticationPrincipal Person person) {
    return ResponseEntity.status(HttpStatus.OK).body(fertilizerService.findAll());
  }

  /**
   * Gets fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> getFertilizerById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(FertilizerDto.entityFromDto(fertilizerService.findById(id)));
  }

  /**
   * Post fertilizer response entity.
   *
   * @param fertilizer the fertilizer
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FertilizerDto> postFertilizer(
      @Valid @RequestBody FertilizerCreationDto fertilizer
  ) {
    FertilizerDto fertilizerSaved = fertilizerService.create(fertilizer.fromEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(fertilizerSaved);
  }
}
