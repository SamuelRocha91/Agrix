package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.CropDtoResponse;
import com.betrybe.agrix.ebytr.staff.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Gets farms.
   *
   * @return the farms
   */
  @GetMapping
  @Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_MANAGER"})
  public ResponseEntity<List<FarmDto>> getFarms() {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getAllFarms());
  }

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) {
    Farm farm =  farmService.getFarm(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(FarmDto.entityFromDto(farm));
  }

  /**
   * Gets crop by farm.
   *
   * @param farmId the farm id
   * @return the crop by farm
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDtoResponse>> getCropByFarm(@PathVariable Long farmId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            farmService.getFarm(farmId)
                .getCrops().stream().map(CropDtoResponse::entityFromDto).toList()
        );
  }

  /**
   * Post farm response entity.
   *
   * @param farm the farm
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDto> postFarm(@RequestBody FarmCreationDto farm) {
    FarmDto farmSaved = farmService.saveFarm(farm.fromEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(farmSaved);
  }

  /**
   * Post crop response entity.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the response entity
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDtoResponse> postCrop(
      @PathVariable Long farmId,
      @RequestBody CropCreationDto crop
  ) {
    Crop cropSaved = farmService.createFarmCrop(farmId, crop.fromEntity());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(CropDtoResponse.entityFromDto(cropSaved));
  }
}
