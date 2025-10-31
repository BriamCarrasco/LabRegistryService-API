package com.briamcarrasco.labregistryservice_api.service;

import com.briamcarrasco.labregistryservice_api.exception.DuplicateResourceException;
import com.briamcarrasco.labregistryservice_api.model.Laboratory;
import com.briamcarrasco.labregistryservice_api.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Override
    public Laboratory saveLaboratory(Laboratory laboratory) {
        try {
            return laboratoryRepository.save(laboratory);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateResourceException("Ya existe un laboratorio con el nombre: " + laboratory.getName());
        }
    }

    @Override
    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepository.findAll();
    }

    @Override
    public Optional<Laboratory> getLaboratoryById(Long id) {
        return laboratoryRepository.findById(id);
    }

    @Override
    public Laboratory updateLaboratory(Long id, Laboratory laboratory) {
        return laboratoryRepository.findById(id)
                .map(existingLab -> {
                    existingLab.setName(laboratory.getName());
                    existingLab.setAddress(laboratory.getAddress());
                    existingLab.setPhone(laboratory.getPhone());
                    existingLab.setEmail(laboratory.getEmail());
                    existingLab.setWebsite(laboratory.getWebsite());
                    existingLab.setSpecialty(laboratory.getSpecialty());
                    return laboratoryRepository.save(existingLab);
                })
                .orElseThrow(() -> new RuntimeException("Laboratorio no encontrado con ID: " + id));
    }

    @Override
    public void deleteLaboratory(Long id) {
        laboratoryRepository.deleteById(id);
    }

    @Override
    public List<Laboratory> findBySpecialty(String specialty) {
        return laboratoryRepository.findBySpecialty(specialty);
    }

    @Override
    public List<Laboratory> findByName(String name) {
        return laboratoryRepository.findByNameContainingIgnoreCase(name);
    }
}