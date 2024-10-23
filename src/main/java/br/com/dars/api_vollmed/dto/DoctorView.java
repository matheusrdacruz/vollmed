package br.com.dars.api_vollmed.dto;

public record DoctorView(
        Long id,
        String name,
        String crm,
        String specialty
) {

}
