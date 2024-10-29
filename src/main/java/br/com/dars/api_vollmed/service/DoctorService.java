package br.com.dars.api_vollmed.service;

import br.com.dars.api_vollmed.domain.Doctor;
import br.com.dars.api_vollmed.dto.DoctorForm;
import br.com.dars.api_vollmed.dto.DoctorFormUpdate;
import br.com.dars.api_vollmed.dto.DoctorView;
import br.com.dars.api_vollmed.mapper.DoctorFormMapper;
import br.com.dars.api_vollmed.mapper.DoctorFormUpdateMapper;
import br.com.dars.api_vollmed.mapper.DoctorViewMapper;
import br.com.dars.api_vollmed.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorFormMapper doctorFormMapper;
    private final DoctorViewMapper doctorViewMapper;
    private final AddressService addressService;
    private final DoctorFormUpdateMapper doctorFormUpdateMapper;

    DoctorService(AddressService addressService, DoctorFormMapper doctorFormMapper,
                  DoctorFormUpdateMapper doctorFormUpdateMapper, DoctorRepository doctorRepository,
                  DoctorViewMapper doctorViewMapper) {
        this.addressService = addressService;
        this.doctorFormMapper = doctorFormMapper;
        this.doctorFormUpdateMapper = doctorFormUpdateMapper;
        this.doctorRepository = doctorRepository;
        this.doctorViewMapper = doctorViewMapper;
    }

    @Transactional
    public DoctorView create(DoctorForm doctorForm) {
        Doctor doctor = doctorFormMapper.map(doctorForm);
        doctor.setAddress(this.addressService.save(doctor.getAddress()));
        this.doctorRepository.save(doctor);
        return this.doctorViewMapper.map(doctor);
    }

    public Page<DoctorView> listAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return this.doctorRepository.findAllByActiveTrue(pageable)
                .map(this.doctorViewMapper::map);
    }

    @Transactional
    public DoctorView update(DoctorFormUpdate formUpdate) {
        Doctor doctor = this.findDoctorById(formUpdate.id());
        this.doctorFormUpdateMapper.update(doctor, formUpdate);
        return this.doctorViewMapper.map(doctor);
    }

    public void delete(Long id) {
        Doctor doctor = this.findDoctorById(id);
        doctor.setActive(false);
        this.doctorRepository.save(doctor);
    }

    public DoctorView findById(Long id) {
        Doctor doctor = this.findDoctorById(id);
        return this.doctorViewMapper.map(doctor);
    }

    private Doctor findDoctorById(Long id) {
        return this.doctorRepository.getReferenceById(id);
    }
}
