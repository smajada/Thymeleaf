package com.smajada.thymeleaf.demo.repository;

import com.smajada.thymeleaf.demo.entities.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}
