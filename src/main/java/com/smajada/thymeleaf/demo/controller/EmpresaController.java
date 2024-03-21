package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.service.ComercialAdministrativoService;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpresaController {

    ComercialAdministrativoService comercialAdministrativoService;
    TrabajadorServicio trabajadorServicio;

    public EmpresaController(ComercialAdministrativoService comercialAdministrativoService, TrabajadorServicio trabajadorServicio) {
        this.comercialAdministrativoService = comercialAdministrativoService;
        this.trabajadorServicio = trabajadorServicio;
    }

    @GetMapping("/")
    public String mostrarTodosLosTrabajadores(Model model) {
        List<Comercial> comerciales = comercialAdministrativoService.listAllComerciales();
        List<Administrativo> administrativos = comercialAdministrativoService.listAllAdministrativos();
        model.addAttribute("comerciales", comerciales);
        model.addAttribute("administrativos", administrativos);
        return "trabajadores"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/administrativos")
    public String crearAdministrativo(Model modelo){
        Administrativo administrativo = new Administrativo();
        modelo.addAttribute("administrativo", administrativo);
        modelo.addAttribute("titlePage", "Nuevo administrativo");
        return "crear_administrativo";
    }

    @GetMapping("/comerciales")
    public String crearComercial(Model modelo){
        Comercial comercial = new Comercial();
        modelo.addAttribute("comercial", comercial);
        modelo.addAttribute("titlePage", "Nuevo comercial");
        return "crear_comercial";
    }

    @GetMapping("/comerciales/editar/{id}")
    public String editarComercial(@PathVariable Long id, Model modelo){
        modelo.addAttribute("comercial", comercialAdministrativoService.getComercialById(id));
        modelo.addAttribute("titlePage", "Editar usuario");
        return "editar_comercial";
    }


    @GetMapping("/administrativos/editar/{id}")
    public String editarAdministrativo(@PathVariable Long id, Model modelo){
        modelo.addAttribute("administrativo", comercialAdministrativoService.getAdministrativoById(id));
        modelo.addAttribute("titlePage", "Editar usuario");
        return "editar_administrativo";
    }

    @PostMapping("/administrativos")
    public String addAdministrativo(@ModelAttribute("administrativo") Administrativo administrativo) {

        if (administrativo.getId() == null) {
            comercialAdministrativoService.addAdministrativo(administrativo);
        } else {
            comercialAdministrativoService.editarAdministrativo(administrativo.getId(), administrativo);
        }

        return "redirect:/";
    }

    @PostMapping("/comerciales")
    public String addComercial(@ModelAttribute("comercial") Comercial comercial) {

        if (comercial.getId() == null) {
            comercialAdministrativoService.addComercial(comercial);
        } else {
            comercialAdministrativoService.editarComercial(comercial.getId(), comercial);
        }

        return "redirect:/";
    }




}
