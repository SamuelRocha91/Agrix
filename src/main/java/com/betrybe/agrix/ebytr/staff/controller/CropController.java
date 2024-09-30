package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDtoResponse;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public ResponseEntity<List<CropDtoResponse>> getAllCrops() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            cropService.getAllCrops()
                .stream().map(CropDtoResponse::entityFromDto).toList()
        );
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<CropDtoResponse> getCropById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            CropDtoResponse.entityFromDto(cropService.getCropById(id))
        );
  }

  /**
   * Gets crop by query.
   *
   * @param start the start
   * @param end   the end
   * @return the crop by query
   */
  @GetMapping("search")
  public ResponseEntity<List<CropDtoResponse>> getCropByQuery(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            cropService.getCropByDate(start, end)
                .stream()
                .map(CropDtoResponse::entityFromDto)
                .toList()
        );
  }

  /**
   * Gets fertilizer by crop.
   *
   * @param cropId the crop id
   * @return the fertilizer by crop
   */
  @GetMapping("/{cropId}/fertilizers")
  public  ResponseEntity<List<FertilizerDto>> getFertilizerByCrop(
      @PathVariable Long cropId
  ) {
    return ResponseEntity.status(HttpStatus.OK).body(
        cropService.getFertilizerByCrop(cropId)
            .stream()
            .map(FertilizerDto::entityFromDto)
            .toList()
    );
  }

  /**
   * Post crop to fertilizers response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> postCropToFertilizers(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    cropService.linkCropToFertilizers(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }
}
