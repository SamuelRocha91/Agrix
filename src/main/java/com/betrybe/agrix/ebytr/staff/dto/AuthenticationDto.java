package com.betrybe.agrix.ebytr.staff.dto;

/**
 * cria dto de autenticação de usuário.
 *
 * @param username string.
 * @param password string.
 */
public record AuthenticationDto(String username, String password) {
}