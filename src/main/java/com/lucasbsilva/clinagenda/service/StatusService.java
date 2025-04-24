package com.lucasbsilva.clinagenda.service;

import com.lucasbsilva.clinagenda.exception.ResourceNotFoundException;
import com.lucasbsilva.clinagenda.model.Status;
import com.lucasbsilva.clinagenda.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatus() { return statusRepository.findAll(); }

    public Status getStatusById(Integer id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Status não encontrado"));
    }

    public Status saveStatus(Status status) { return statusRepository.save(status); }

    public void deleteStatus(Integer id) { statusRepository.deleteById(id); }

    public Status updateStatus(Integer id, Status status) {
        Status existingStatus = statusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada: " + id));

        existingStatus.setName(status.getName());

        return statusRepository.save(existingStatus);
    }
}
