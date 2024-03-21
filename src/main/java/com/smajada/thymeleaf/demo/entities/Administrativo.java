package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "administrativos")
public class Administrativo extends Trabajador{

    public Administrativo(String nombre, String apellido, String email, int numVentasTotales) {
        super(nombre, apellido, email);
        this.numVentasTotales = numVentasTotales;
    }

    @Column
    private int numVentasTotales;

}
