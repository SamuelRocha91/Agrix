package com.betrybe.agrix.ebytr.staff.dto;

/**
 * Dto de resposta do cadastro.
 *
 * @param id LOng.
 * @param username nma.
 * @param role autorizacao.
 */
public record  PersonDtoResponse(Long id, String username, String role) {

}
