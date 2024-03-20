package com.smajada.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//@PrimaryKeyJoinColumn(referencedColumnName = "trabajador_id")
public class Comercial extends Trabajador{

    public Comercial(Long id, String nombre, String apellido, String email, int objetivoVentasMensuales) {
        super(id, nombre, apellido, email);
        this.objetivoVentasMensuales = objetivoVentasMensuales;
    }

    public Comercial(String nombre, String apellido, String email, int objetivoVentasMensuales) {
        super(nombre, apellido, email);
        this.objetivoVentasMensuales = objetivoVentasMensuales;
    }

    @Column(name = "objetivo_ventas_mensuales")
    private int objetivoVentasMensuales;
}
