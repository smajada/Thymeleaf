package com.smajada.thymeleaf.demo.service;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.repository.AdministrativoRepository;
import com.smajada.thymeleaf.demo.repository.ComercialRepository;
import org.springframework.stereotype.Service;

@Service
public class ComercialAdministrativoService {
    ComercialRepository comercialRepository;
    AdministrativoRepository administrativoRepository;

    public ComercialAdministrativoService(ComercialRepository comercialRepository, AdministrativoRepository administrativoRepository) {
        this.comercialRepository = comercialRepository;
        this.administrativoRepository = administrativoRepository;
    }

    public Comercial addComercial(Comercial comercial){
        return comercialRepository.save(comercial);
    }

    public Administrativo addAdministrativo(Administrativo administrativo){
        return administrativoRepository.save(administrativo);
    }


}
