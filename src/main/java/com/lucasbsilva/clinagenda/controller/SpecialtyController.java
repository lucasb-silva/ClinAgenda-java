package com.lucasbsilva.clinagenda.controller;

import com.lucasbsilva.clinagenda.model.Specialty;
import com.lucasbsilva.clinagenda.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/{id}")
    public Specialty getSpecialtyById(@PathVariable Integer id) {
        return specialtyService.getSpecialtyById(id);
    }

    @PostMapping
    public Specialty createSpecialty(@RequestBody Specialty specialty) {
        return specialtyService.saveSpecialty(specialty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialty(@PathVariable Integer id) {
        specialtyService.deleteSpecialty(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar uma especialidade
    @PutMapping("/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable Integer id, @RequestBody Specialty specialty) {
        Specialty updatedSpecialty = specialtyService.updateSpecialty(id, specialty);
        return ResponseEntity.ok(updatedSpecialty);
    }
}
