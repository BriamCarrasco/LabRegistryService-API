package com.briamcarrasco.labregistryservice_api.service;

import com.briamcarrasco.labregistryservice_api.model.Laboratory;
import java.util.List;
import java.util.Optional;

public interface LaboratoryService {
    
    Laboratory saveLaboratory(Laboratory laboratory);
    List<Laboratory> getAllLaboratories();
    Optional<Laboratory> getLaboratoryById(Long id);
    Laboratory updateLaboratory(Long id, Laboratory laboratory);
    void deleteLaboratory(Long id);
    List<Laboratory> findBySpecialty(String specialty);
    List<Laboratory> findByName(String name);
}