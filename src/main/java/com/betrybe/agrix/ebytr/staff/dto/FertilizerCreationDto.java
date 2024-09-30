package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.model.entity.Fertilizer;

/**
 * The type Fertilizer creation dto.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

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
