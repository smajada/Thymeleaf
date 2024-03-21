package com.smajada.thymeleaf.demo.repository;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {
}
