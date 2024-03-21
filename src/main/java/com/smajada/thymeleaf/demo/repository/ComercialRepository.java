package com.smajada.thymeleaf.demo.repository;

import com.smajada.thymeleaf.demo.entities.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercialRepository extends JpaRepository<Comercial, Long> {
}
