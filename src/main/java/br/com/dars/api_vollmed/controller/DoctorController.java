package br.com.dars.api_vollmed.controller;

import br.com.dars.api_vollmed.dto.DoctorForm;
import br.com.dars.api_vollmed.dto.DoctorFormUpdate;
import br.com.dars.api_vollmed.dto.DoctorView;
import br.com.dars.api_vollmed.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public Page<DoctorView> listAll(Pageable pageable) {
        return this.doctorService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public DoctorView findById(@PathVariable Long id) {
        return this.doctorService.findById(id);
    }

    @PostMapping
    public DoctorView create(@RequestBody @Valid DoctorForm doctor) {
        return this.doctorService.create(doctor);
    }

    @PutMapping
    public DoctorView update(@RequestBody @Valid DoctorFormUpdate doctor) {
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        this.doctorService.delete(id);
        return "Doctor deleted";
    }
}
