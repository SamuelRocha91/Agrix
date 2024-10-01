package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
/**
 * The type Crop creation dto.
 */
public record CropCreationDto(
    @NotBlank(message = "Name is Required")
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate
) {

  /**
   * From entity crop.
   *
   * @return the crop
   */
  public Crop fromEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}
