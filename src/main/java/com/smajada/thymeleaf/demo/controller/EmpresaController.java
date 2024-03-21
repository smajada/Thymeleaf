package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.service.ComercialAdministrativoService;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    ComercialAdministrativoService comercialAdministrativoService;
    TrabajadorServicio trabajadorServicio;

    public EmpresaController(ComercialAdministrativoService comercialAdministrativoService, TrabajadorServicio trabajadorServicio) {
        this.comercialAdministrativoService = comercialAdministrativoService;
        this.trabajadorServicio = trabajadorServicio;
    }

    @PostMapping("addComercial")
    public Comercial addComercial(@RequestBody Comercial comercial){
        return comercialAdministrativoService.addComercial(comercial);
    }

    @PostMapping("addAdministrativo")
    public Administrativo addAdministrativo(@RequestBody Administrativo administrativo){
        return comercialAdministrativoService.addAdministrativo(administrativo);
    }

    @GetMapping("listTrabajadores")
    public List<Trabajador> listTrabajadores(){
        return trabajadorServicio.listAllTrabajadores();
    }
}
