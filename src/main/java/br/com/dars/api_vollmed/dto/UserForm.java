package br.com.dars.api_vollmed.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank String name,
        @NotBlank String username,
        @NotBlank @Email String email,
        @NotBlank @Email String emailConfirmation,
        @NotBlank String password,
        @NotBlank String passwordConfirmation
) {
}
