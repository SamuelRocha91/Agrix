package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * cria o Fertilizer em dto para recebimento de dados do cliente.
 *
 * @param name string.
 * @param brand string.
 * @param composition string.
 */
public record FertilizerDto(String name, String brand, String composition) {

  /**
   * cria um Fertilizer  a partir de dados do cliente.
   *
   * @return Fertilizer.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}
