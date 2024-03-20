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
@AllArgsConstructor
//@PrimaryKeyJoinColumn(referencedColumnName = "trabajador_id")
public class Comercial extends Trabajador{

    @Column(name = "objetivo_ventas_mensuales")
    private double objetivoVentasMensuales;

    @Column(name = "porcentaje_comision")
    private double porcentajeComision;
}
