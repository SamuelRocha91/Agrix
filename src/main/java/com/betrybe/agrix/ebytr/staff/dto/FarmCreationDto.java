package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * cria dto de farm para recebimento de dados do cliente.
 *
 * @param name uma string com o nome da fazenda.
 * @param size DOuble o tamanho.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * converte um farmDTo recebido numa entidade.
   *
   * @return FArm.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }

}