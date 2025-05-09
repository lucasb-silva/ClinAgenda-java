package com.lucasbsilva.clinagenda.mapper;

import com.lucasbsilva.clinagenda.dto.DoctorDTO;
import com.lucasbsilva.clinagenda.model.Doctor;
import com.lucasbsilva.clinagenda.model.Status;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setStatusId(dto.getStatusId());
        return doctor;
    }

    public DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setStatusId(doctor.getStatusId());
        return dto;
    }
}

