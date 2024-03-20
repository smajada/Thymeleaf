package com.smajada.thymeleaf.demo.service;


import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.TrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrabajadorServicio {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorServicio(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<Trabajador> listAllTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Trabajador guardarTrabajadores(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador getTrabajadorporId(Long id){
        return trabajadorRepository.getReferenceById(id);
    }

    public Trabajador actualizarTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public void eliminarTrabajador(Long id){
        trabajadorRepository.deleteById(id);
    }

}
