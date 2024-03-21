package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "comerciales")
public class Comercial extends Trabajador{

    public Comercial(String nombre, String apellido, String email, String departamento) {
        super(nombre, apellido, email);
        this.departamento = departamento;
    }

    @Column
    private String departamento;
}
