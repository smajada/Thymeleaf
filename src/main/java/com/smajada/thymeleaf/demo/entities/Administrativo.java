package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Administrativo extends Trabajador{

    private int numVentasTotales;

    public Administrativo(String nombre, String apellido, String email, int numVentasTotales) {
        super(nombre, apellido, email);
        this.numVentasTotales = numVentasTotales;
    }


}
