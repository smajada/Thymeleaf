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
@AllArgsConstructor
public class Administrativo extends Trabajador{

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "horario_trabajo")
    private String horarioTrabajo;
}
