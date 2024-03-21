package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.*;
import lombok.*;

//@Entity
@Setter
@Getter
@ToString
@MappedSuperclass
public abstract class Trabajador {

    public Trabajador(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "email", nullable = false, length = 50)
    private String email;


    public Trabajador() {

    }
}
