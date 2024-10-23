package br.com.dars.api_vollmed.mapper;

import br.com.dars.api_vollmed.domain.Doctor;
import br.com.dars.api_vollmed.domain.Specialty;
import br.com.dars.api_vollmed.dto.DoctorFormUpdate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DoctorFormUpdateMapper {

    public Doctor map(DoctorFormUpdate form) {
        Doctor doctor = new Doctor();
        doctor.setId(form.id());
        return this.update(doctor, form);
    }

    public Doctor update(Doctor doctor, DoctorFormUpdate form) {
        if (StringUtils.isNotBlank(form.name())) {
            doctor.setName(form.name());
        }
        if (StringUtils.isNotBlank(form.email())) {
            doctor.setEmail(form.email());
        }
        if (StringUtils.isNotBlank(form.phone())) {
            doctor.setPhone(form.phone());
        }
        if (StringUtils.isNotBlank(form.specialty())) {
            doctor.setSpecialty(Specialty.find(form.specialty()));
        }
        if (StringUtils.isNotBlank(form.crm())) {
            doctor.setCrm(form.crm());
        }
        return doctor;
    }
}
