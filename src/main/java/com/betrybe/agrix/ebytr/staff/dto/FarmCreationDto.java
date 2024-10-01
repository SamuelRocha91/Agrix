package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Farm;
import jakarta.validation.constraints.NotBlank;

/**
 * The type Farm creation dto.
 */
public record FarmCreationDto(
    @NotBlank(message = "Name is Required")
    String name,
    @NotBlank(message = "Size is Required")
    Double size) {

  /**
   * From entity farm.
   *
   * @return the farm
   */
  public Farm fromEntity() {
    return new Farm(name, size);
  }


}
