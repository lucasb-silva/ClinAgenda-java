package com.lucasbsilva.clinagenda.repository;

import com.lucasbsilva.clinagenda.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
