package com.betrybe.agrix.ebytr.staff.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The type Auth dto.
 */
public record AuthDto(
    @NotBlank(message = "Name is Required")
    String username,

    @Size(min = 8, message = "Password must have at least 8 characters")
    @NotBlank(message = "Password is Required")
    String password
) {
}
