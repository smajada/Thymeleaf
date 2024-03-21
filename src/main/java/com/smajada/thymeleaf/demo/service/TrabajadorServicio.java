package com.smajada.thymeleaf.demo.service;


import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
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
        return trabajadorRepository.findById(id).orElse(null);
    }

    public void actualizarTrabajador(Trabajador trabajador, Long id){
        trabajadorRepository.findById(id)
                .ifPresent(trabajador1 -> {
                    trabajador1.setNombre(trabajador.getNombre());
                    trabajador1.setApellido(trabajador.getApellido());
                    trabajador1.setEmail(trabajador.getEmail());
                    if (trabajador1 instanceof Administrativo){
                        ((Administrativo) trabajador1).setDepartamento(((Administrativo) trabajador).getDepartamento());
                    } else {
                        ((Comercial) trabajador1).setObjetivoVentasMensuales(((Comercial) trabajador).getObjetivoVentasMensuales());
                    }

                    trabajadorRepository.save(trabajador1);
                });
    }

    public void eliminarTrabajador(Long id){
        trabajadorRepository.deleteById(id);
    }

}
