package com.betrybe.agrix.ebytr.staff.dto;

/**
 * cria um dto para responder requisicoes que envolvem a tabela farm.
 *
 * @param id Long
 * @param name String
 * @param size Double.
 */
public record FarmDtoResponse(Long id, String name, Double size) {

}