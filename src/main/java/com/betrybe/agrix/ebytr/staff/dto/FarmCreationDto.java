package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * The type Farm creation dto.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * From entity farm.
   *
   * @return the farm
   */
  public Farm fromEntity() {
    return new Farm(name, size);
  }
}
