package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Comercial extends Trabajador{

    private String departamento;

    public Comercial(String nombre, String apellido, String email, String departamento) {
        super(nombre, apellido, email);
        this.departamento = departamento;
    }
}
