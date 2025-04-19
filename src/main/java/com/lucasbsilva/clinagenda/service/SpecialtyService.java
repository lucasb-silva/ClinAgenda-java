package com.lucasbsilva.clinagenda.service;

import com.lucasbsilva.clinagenda.model.Specialty;
import com.lucasbsilva.clinagenda.exception.ResourceNotFoundException;
import com.lucasbsilva.clinagenda.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    // Usa método findAll do JPA repository para obter uma lista de objetos Specialty
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    // Retorna objeto Specialty pelo ID ou mensagem de erro
    public Specialty getSpecialtyById(Integer id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada"));
    }


    // Salva um objeto Specialty no banco de dados e retorna o objeto
    public Specialty saveSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    // Deleta o registro de Specialty pelo id
    public void deleteSpecialty(Integer id) {
        specialtyRepository.deleteById(id);
    }

    public Specialty updateSpecialty(Integer id, Specialty specialty) {
        // Verifica se a especialidade existe
        Specialty existingSpecialty = specialtyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especilalidade não encontrada: " + id));

        // Atualiza os dados
        existingSpecialty.setName(specialty.getName());
        existingSpecialty.setScheduleDuration(specialty.getScheduleDuration());
        // Adicione outros campos conforme necessário

        // Salva e retorna a especialidade atualizada
        return specialtyRepository.save(existingSpecialty);
    }
}
