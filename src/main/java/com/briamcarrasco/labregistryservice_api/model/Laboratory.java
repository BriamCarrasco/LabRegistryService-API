package com.briamcarrasco.labregistryservice_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_laboratories")
@Data
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory")
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    @Column(name = "nameLaboratory", unique = true)
    private String name;

    @NotBlank(message = "La dirección es obligatoria")
    @Column(name = "addressLaboratory")
    private String address;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "phoneLaboratory")
    private String phone;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    @Column(name = "emailLaboratory")
    private String email;

    @Column(name = "websiteLaboratory")
    private String website;

    @NotBlank(message = "La especialidad es obligatoria")
    @Column(name = "specialtyLaboratory")
    private String specialty;

    public Laboratory() {
    }
    
}
