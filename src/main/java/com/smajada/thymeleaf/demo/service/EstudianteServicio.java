package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Estudiante;
import com.smajada.thymeleaf.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteServicio {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServicio(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listAllEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Estudiante getEstudianteporId(Long id){
        return estudianteRepository.getReferenceById(id);
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
}
