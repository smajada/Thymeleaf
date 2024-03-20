package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrabajadorServicio {

    private final EstudianteRepository estudianteRepository;

    public TrabajadorServicio(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Trabajador> listAllTrabajadores(){
        return estudianteRepository.findAll();
    }

    public Trabajador guardarTrabajadores(Trabajador trabajador){
        return estudianteRepository.save(trabajador);
    }

    public Trabajador getTrabajadorporId(Long id){
        return estudianteRepository.getReferenceById(id);
    }

    public Trabajador actualizarTrabajador(Trabajador trabajador){
        return estudianteRepository.save(trabajador);
    }

    public void eliminarTrabajador(Long id){
        estudianteRepository.deleteById(id);
    }
}
