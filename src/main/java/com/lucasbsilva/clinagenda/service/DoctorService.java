package com.lucasbsilva.clinagenda.service;

import com.lucasbsilva.clinagenda.dto.DoctorDTO;
import com.lucasbsilva.clinagenda.exception.ResourceNotFoundException;
import com.lucasbsilva.clinagenda.mapper.DoctorMapper;
import com.lucasbsilva.clinagenda.model.Doctor;
import com.lucasbsilva.clinagenda.model.Status;
import com.lucasbsilva.clinagenda.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doutor não encontrado"));
        return doctorMapper.toDTO(doctor);
    }

    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDTO(savedDoctor);
    }


    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }

    public DoctorDTO updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doutor não encontrado: " + id));

        existingDoctor.setName(doctorDTO.getName());
        existingDoctor.setStatusId(doctorDTO.getStatusId());

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return doctorMapper.toDTO(updatedDoctor);
    }
}