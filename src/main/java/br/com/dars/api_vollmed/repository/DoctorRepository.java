package br.com.dars.api_vollmed.repository;

import br.com.dars.api_vollmed.domain.Doctor;
import br.com.dars.api_vollmed.mapper.DoctorFormMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pageable);
}
