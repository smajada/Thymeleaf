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

    @PostMapping("/comerciales")
    public String addComercial(@RequestBody Comercial comercial) {
         comercialAdministrativoService.addComercial(comercial);
        return "redirect:/";
    }

    @PostMapping("/administrativos")
    public String addAdministrativo(@RequestBody Administrativo administrativo) {
         comercialAdministrativoService.addAdministrativo(administrativo);
        return "redirect:/";
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

    @PostMapping("/comerciales")
    public String editarComercial(@RequestBody Comercial comercial,  @PathVariable Long id) {
        comercialAdministrativoService.editarComercial(id, comercial);
        return "redirect:/";
    }

    @PostMapping("/administrativos")
    public String editarAdministrativo(@RequestBody Administrativo administrativo, @PathVariable Long id) {
        comercialAdministrativoService.editarAdministrativo(id, administrativo);
        return "redirect:/";
    }




}
