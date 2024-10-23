package br.com.dars.api_vollmed.mapper;

import br.com.dars.api_vollmed.domain.Doctor;
import br.com.dars.api_vollmed.domain.Specialty;
import br.com.dars.api_vollmed.dto.DoctorForm;
import br.com.dars.api_vollmed.dto.DoctorView;
import org.springframework.stereotype.Component;

@Component
public class DoctorViewMapper {
    private AddressFormMapper addressFormMapper;

    public DoctorViewMapper(AddressFormMapper addressFormMapper) {
        this.addressFormMapper = addressFormMapper;
    }

    public DoctorView map(Doctor doctor) {
        return new DoctorView(doctor.getId(), doctor.getName(),doctor.getCrm(),
                doctor.getSpecialty().getDescription());
    }
}
