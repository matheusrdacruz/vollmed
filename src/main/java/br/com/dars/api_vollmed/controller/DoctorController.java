package br.com.dars.api_vollmed.controller;

import br.com.dars.api_vollmed.dto.DoctorForm;
import br.com.dars.api_vollmed.dto.DoctorFormUpdate;
import br.com.dars.api_vollmed.dto.DoctorView;
import br.com.dars.api_vollmed.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<Page<DoctorView>> listAll(Pageable pageable) {
        return ResponseEntity.ok(this.doctorService.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorView> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.doctorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorView> create(@RequestBody @Valid DoctorForm doctor, UriComponentsBuilder uriBuilder) {
        var newDoctor = this.doctorService.create(doctor);
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(newDoctor.id()).toUri();
        return ResponseEntity.created(uri).body(newDoctor);
    }

    @PutMapping
    public ResponseEntity<DoctorView> update(@RequestBody @Valid DoctorFormUpdate doctor) {
        return ResponseEntity.ok(this.doctorService.update(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
