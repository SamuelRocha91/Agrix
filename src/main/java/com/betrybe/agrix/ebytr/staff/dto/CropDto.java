package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Dto para recebimento de dados sobre plantações do cliente.
 *
 * @param name String.
 * @param plantedArea DOuble
 */
public record CropDto(String name, Double plantedArea, String plantedDate,
                      String harvestDate) {

  /**
   * método que converte de Drto para a entidade.
   *
   * @return um new Crop.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setHarvestDate(LocalDate.parse(harvestDate));
    crop.setPlantedDate(LocalDate.parse(plantedDate));
    return crop;
  }
}
