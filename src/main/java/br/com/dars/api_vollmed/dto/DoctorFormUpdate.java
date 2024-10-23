package br.com.dars.api_vollmed.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorFormUpdate(
        @NotNull
        Long id,
        String name,
        @Email
        String email,
        String phone,
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        String specialty
) {
}
