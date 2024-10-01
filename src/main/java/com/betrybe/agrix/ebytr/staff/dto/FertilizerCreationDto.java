package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Fertilizer;
import jakarta.validation.constraints.NotBlank;

/**
 * The type Fertilizer creation dto.
 */
public record FertilizerCreationDto(
    @NotBlank(message = "Name is Required")
    String name,
    String brand,
    String composition
) {

  /**
   * From entity fertilizer.
   *
   * @return the fertilizer
   */
  public Fertilizer fromEntity() {
    return new Fertilizer(
      name, brand, composition
    );
  }
}
