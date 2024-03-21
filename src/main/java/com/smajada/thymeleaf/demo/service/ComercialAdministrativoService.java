package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
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

    }




}
