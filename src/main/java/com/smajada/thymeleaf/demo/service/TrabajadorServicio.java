package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.AdministrativoRepository;
import com.smajada.thymeleaf.demo.repository.ComercialRepository;
import com.smajada.thymeleaf.demo.repository.TrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrabajadorServicio {

    private final TrabajadorRepository trabajadorRepository;
    private final ComercialRepository comercialRepository;
    private final AdministrativoRepository administrativoRepository;

    public TrabajadorServicio(TrabajadorRepository trabajadorRepository, ComercialRepository comercialRepository, AdministrativoRepository administrativoRepository) {
        this.trabajadorRepository = trabajadorRepository;
        this.comercialRepository = comercialRepository;
        this.administrativoRepository = administrativoRepository;
    }

    public List<Trabajador> listAllTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Comercial addComercial(Comercial comercial){
        return comercialRepository.save(comercial);
    }

    public Administrativo addAdministrativo(Administrativo administrativo){
        return administrativoRepository.save(administrativo);
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

                    trabajadorRepository.save(trabajador1);
                });
    }

    public void eliminarTrabajador(Long id){
        trabajadorRepository.deleteById(id);
    }
}
