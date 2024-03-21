package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.AdministrativoRepository;
import com.smajada.thymeleaf.demo.repository.ComercialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialAdministrativoService {
    ComercialRepository comercialRepository;
    AdministrativoRepository administrativoRepository;

    public ComercialAdministrativoService(ComercialRepository comercialRepository, AdministrativoRepository administrativoRepository) {
        this.comercialRepository = comercialRepository;
        this.administrativoRepository = administrativoRepository;
    }

    public List<Comercial> listAllComerciales() {return  comercialRepository.findAll();}
    public List<Administrativo> listAllAdministrativos() {return administrativoRepository.findAll();}

    public Comercial addComercial(Comercial comercial){
        return comercialRepository.save(comercial);
    }

    public Administrativo addAdministrativo(Administrativo administrativo){
        return administrativoRepository.save(administrativo);
    }

    public Comercial getComercialById(Long id){
        return comercialRepository.getReferenceById(id);
    }

    public Administrativo getAdministrativoById(Long id){
        return administrativoRepository.getReferenceById(id);
    }

    public void editarComercial(Long id, Comercial comercial){
        comercialRepository.findById(id)
                .ifPresent(comercial1 -> {
                    comercial1.setNombre(comercial.getNombre());
                    comercial1.setApellido(comercial.getApellido());
                    comercial1.setEmail(comercial.getEmail());
                    comercial1.setDepartamento(comercial.getDepartamento());

                    comercialRepository.save(comercial1);
                });
    }

    public void editarAdministrativo(Long id, Administrativo administrativo){
        administrativoRepository.findById(id)
                .ifPresent(administrativo1 -> {
                    administrativo1.setNombre(administrativo.getNombre());
                    administrativo1.setApellido(administrativo.getApellido());
                    administrativo1.setEmail(administrativo.getEmail());
                    administrativo1.setNumVentasTotales(administrativo.getNumVentasTotales());

                    administrativoRepository.save(administrativo1);
                });

    }

    public void eliminarAdministrativo(Long id){
        administrativoRepository.deleteById(id);
    }


    public void eliminarComercial(Long id){
        comercialRepository.deleteById(id);
    }


}
