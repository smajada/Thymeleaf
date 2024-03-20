package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
//@PrimaryKeyJoinColumn(referencedColumnName = "trabajador_id")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Administrativo extends Trabajador{

    public Administrativo(Long id, String nombre, String apellido, String email, String departamento) {
        super(id, nombre, apellido, email);
        this.departamento = departamento;
    }

    public Administrativo(String nombre, String apellido, String email, String departamento) {
        super(nombre, apellido, email);
        this.departamento = departamento;
    }

    @Column(name = "departamento")
    private String departamento;
}
