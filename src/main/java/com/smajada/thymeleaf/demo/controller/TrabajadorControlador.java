package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.AdministrativoRepository;
import com.smajada.thymeleaf.demo.repository.ComercialRepository;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrabajadorControlador {

    private final TrabajadorServicio trabajadorServicio;
    private final AdministrativoRepository administrativoRepository;
    private final ComercialRepository comercialRepository;

    public TrabajadorControlador(TrabajadorServicio trabajadorServicio, AdministrativoRepository administrativoRepository, ComercialRepository comercialRepository) {
        this.trabajadorServicio = trabajadorServicio;
        this.administrativoRepository = administrativoRepository;
        this.comercialRepository = comercialRepository;
    }

    @GetMapping({ "/"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("trabajadores", trabajadorServicio.listAllTrabajadores());
        modelo.addAttribute("titlePage", "Listado");
        return "trabajadores";
    }

    @GetMapping("/administrativos")
    public String crearAdministrativo(Model modelo) {
        Administrativo administrativo = new Administrativo();
        modelo.addAttribute("administrativo", administrativo);
        modelo.addAttribute("titlePage", "Nuevo administrativo");
        return "crear_administrativo";
    }

    @GetMapping("/comerciales")
    public String crearComercial(Model modelo) {
        Comercial comercial = new Comercial();
        modelo.addAttribute("comercial", comercial);
        modelo.addAttribute("titlePage", "Nuevo comercial");
        return "crear_comercial";
    }

    @GetMapping("/trabajadores/editar/{id}")
    public String editarTrabajador(@PathVariable Long id, Model modelo){
        if (trabajadorServicio.getTrabajadorporId(id).getClass().equals(Administrativo.class)){
            Administrativo administrativo = administrativoRepository.findById(id).orElse(null);
            modelo.addAttribute("trabajador", administrativo);
        } else {
            Comercial comercial = comercialRepository.findById(id).orElse(null);
            modelo.addAttribute("trabajador", comercial);
        }
        modelo.addAttribute("titlePage", "Editar usuario");
        return "editar_trabajador";
    }

    @PostMapping("/administrativos")
    public String guardarAdministrativo(@ModelAttribute("administrativo") Administrativo administrativo) {

        if (administrativo.getId() == null) {
            trabajadorServicio.addAdministrativo(administrativo);
        } else {
            trabajadorServicio.actualizarTrabajador(administrativo, administrativo.getId());
        }

        return "redirect:/";
    }

    @PostMapping("/comerciales")
    public String guardarComercial(@ModelAttribute("comercial") Comercial comercial) {

        if (comercial.getId() == null) {
            trabajadorServicio.addComercial(comercial);
        } else {
            trabajadorServicio.actualizarTrabajador(comercial, comercial.getId());
        }

        return "redirect:/";
    }

    @GetMapping("/trabajadores/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        trabajadorServicio.eliminarTrabajador(id);

        return "redirect:/trabajadores";
    }

}