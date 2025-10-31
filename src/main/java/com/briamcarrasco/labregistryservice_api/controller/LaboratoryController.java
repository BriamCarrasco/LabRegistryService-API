package com.briamcarrasco.labregistryservice_api.controller;

import com.briamcarrasco.labregistryservice_api.model.Laboratory;
import com.briamcarrasco.labregistryservice_api.service.LaboratoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Laboratories", description = "Operaciones CRUD para laboratorios")
@RestController
@RequestMapping("/api/laboratories")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    @Operation(summary = "Crear un nuevo laboratorio")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Laboratorio creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<Laboratory> createLaboratory(@RequestBody Laboratory laboratory) {
        Laboratory savedLab = laboratoryService.saveLaboratory(laboratory);
        return ResponseEntity.ok(savedLab);
    }

    @Operation(summary = "Obtener todos los laboratorios")
    @ApiResponse(responseCode = "200", description = "Lista de laboratorios")
    @GetMapping
    public ResponseEntity<List<Laboratory>> getAllLaboratories() {
        return ResponseEntity.ok(laboratoryService.getAllLaboratories());
    }

    @Operation(summary = "Obtener laboratorio por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Laboratorio encontrado"),
        @ApiResponse(responseCode = "404", description = "Laboratorio no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratoryById(@PathVariable Long id) {
        return laboratoryService.getLaboratoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar laboratorio por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Laboratorio actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Laboratorio no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Laboratory> updateLaboratory(@PathVariable Long id, @RequestBody Laboratory laboratory) {
        try {
            Laboratory updatedLab = laboratoryService.updateLaboratory(id, laboratory);
            return ResponseEntity.ok(updatedLab);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar laboratorio por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Laboratorio eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Laboratorio no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratory(@PathVariable Long id) {
        laboratoryService.deleteLaboratory(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar laboratorios por especialidad")
    @ApiResponse(responseCode = "200", description = "Lista de laboratorios por especialidad")
    @GetMapping("/specialty/{specialty}")
    public ResponseEntity<List<Laboratory>> getBySpecialty(@PathVariable String specialty) {
        return ResponseEntity.ok(laboratoryService.findBySpecialty(specialty));
    }

    @Operation(summary = "Buscar laboratorios por nombre")
    @ApiResponse(responseCode = "200", description = "Lista de laboratorios por nombre")
    @GetMapping("/search")
    public ResponseEntity<List<Laboratory>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(laboratoryService.findByName(name));
    }
}