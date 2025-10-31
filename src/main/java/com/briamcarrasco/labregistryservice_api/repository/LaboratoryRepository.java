package com.briamcarrasco.labregistryservice_api.repository;

import com.briamcarrasco.labregistryservice_api.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

    List<Laboratory> findBySpecialty(String specialty);

    List<Laboratory> findByNameContainingIgnoreCase(String name);

    Optional<Laboratory> findById(Long id);
}