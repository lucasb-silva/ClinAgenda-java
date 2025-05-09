package com.lucasbsilva.clinagenda.repository;

import com.lucasbsilva.clinagenda.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
