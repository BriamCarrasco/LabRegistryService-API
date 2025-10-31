package com.briamcarrasco.labregistryservice_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Table(name = "tb_laboratories")
@Data
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory")
    private long id;

    @Column(name = "nameLaboratory")
    private String name;

    @Column(name = "addressLaboratory")
    private String address;

    @Column(name = "phoneLaboratory")
    private String phone;

    @Column(name = "emailLaboratory")
    private String email;

    @Column(name = "websiteLaboratory")
    private String website;

    @Column(name = "specialtyLaboratory")
    private String specialty;

    public Laboratory() {
    }
    
}
