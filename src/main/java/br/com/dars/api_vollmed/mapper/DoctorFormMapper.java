package br.com.dars.api_vollmed.mapper;

import br.com.dars.api_vollmed.domain.Doctor;
import br.com.dars.api_vollmed.domain.Specialty;
import br.com.dars.api_vollmed.dto.DoctorForm;
import org.springframework.stereotype.Component;

@Component
public class DoctorFormMapper {
    private AddressFormMapper addressFormMapper;

    public DoctorFormMapper(AddressFormMapper addressFormMapper) {
        this.addressFormMapper = addressFormMapper;
    }

    public Doctor map(DoctorForm form) {
        Doctor doctor = new Doctor();
        doctor.setName(form.name());
        doctor.setEmail(form.email());
        doctor.setPhone(form.phone());
        doctor.setSpecialty(Specialty.find(form.specialty()));
        doctor.setCrm(form.crm());
        doctor.setAddress(this.addressFormMapper.map(form.address()));
        return doctor;
    }
}
