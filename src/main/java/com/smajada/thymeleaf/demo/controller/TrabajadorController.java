package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.AdministrativoRepository;
import com.smajada.thymeleaf.demo.repository.ComercialRepository;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrabajadorController {

    private final TrabajadorServicio trabajadorServicio;
    private final ComercialRepository comercialRepository;
    private final AdministrativoRepository administrativoRepository;

    public TrabajadorController(TrabajadorServicio trabajadorServicio, ComercialRepository comercialRepository, AdministrativoRepository administrativoRepository) {
        this.trabajadorServicio = trabajadorServicio;
        this.comercialRepository = comercialRepository;
        this.administrativoRepository = administrativoRepository;
    }

    @GetMapping({"/trabajadores", "/"})
    public String listarTrabajadores(Model modelo){
        modelo.addAttribute("trabajadores", trabajadorServicio.listAllTrabajadores());
        modelo.addAttribute("titlePage", "Listado");
        return "trabajadores";
    }

    @GetMapping("/trabajadores/nuevo_administrativo")
    public String mostrarAdministrativosFormulario(Model modelo){
        modelo.addAttribute("administrativo", new Administrativo());
        modelo.addAttribute("titlePage", "Nuevo administrativo");
        return "crear_administrativo";
    }

    @GetMapping("/trabajadores/nuevo_comercial")
    public String mostrarComercialesFormulario(Model modelo){
        modelo.addAttribute("comercial", new Comercial());
        modelo.addAttribute("titlePage", "Nuevo comercial");
        return "crear_comercial";
    }

    @PostMapping("/trabajadores/administrativo")
    public String guardarAdministrativo(@ModelAttribute("administrativo") Administrativo administrativo) {

            if (administrativo.getId() == null) {
                trabajadorServicio.guardarTrabajadores(administrativo);
            } else {
                trabajadorServicio.actualizarTrabajador(administrativo, administrativo.getId());
            }

        return "redirect:/trabajadores";
    }

    @PostMapping("/trabajadores/comercial")
    public String guardarComercial(@ModelAttribute("comercial") Comercial comercial) {

            if (comercial.getId() == null) {
                trabajadorServicio.guardarTrabajadores(comercial);
            } else {
                trabajadorServicio.actualizarTrabajador(comercial, comercial.getId());
            }

        return "redirect:/trabajadores";
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

    @GetMapping("/trabajadores/{id}")
    public String eliminarTrabajador(@PathVariable Long id){
        trabajadorServicio.eliminarTrabajador(id);

        return "redirect:/trabajadores";
    }

}
