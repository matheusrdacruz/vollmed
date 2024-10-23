package br.com.dars.api_vollmed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressForm(
        @NotBlank
        String city,
        @NotBlank
        String street,
        Integer number,
        @NotBlank
        String neighborhood,
        @NotBlank
        String state,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String zipcode,
        String complement
) {
}
