package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * The type Crop dto response.
 */
public record CropDtoResponse(
    Long id,
    String name,
    Double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate
) {

  /**
   * Entity from dto crop dto response.
   *
   * @param crop the crop
   * @return the crop dto response
   */
  public static CropDtoResponse entityFromDto(Crop crop) {
    return new CropDtoResponse(
        crop.getId(),
        crop.getName(),
        crop.getPlanted_area(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
        );
  }
}
