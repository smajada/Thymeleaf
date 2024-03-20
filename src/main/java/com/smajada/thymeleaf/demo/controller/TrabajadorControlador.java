package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrabajadorControlador {

    private final TrabajadorServicio trabajadorServicio;

    public TrabajadorControlador(TrabajadorServicio trabajadorServicio) {
        this.trabajadorServicio = trabajadorServicio;
    }

    @GetMapping({"/trabajadores", "/"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("trabajadores", trabajadorServicio.listAllTrabajadores());
        modelo.addAttribute("titlePage", "Listado");
        return "trabajadores";
    }

    @GetMapping("/trabajadores/nuevo")
    public String mostrarEstudianteFormulario(Model modelo){
        Trabajador trabajador = new Trabajador();
        modelo.addAttribute("trabajador", trabajador);
        modelo.addAttribute("titlePage", "Nuevo trabajador");
        return "crear_trabajador";
    }

    @PostMapping("/trabajadores")
    public String guardarEstudiante(@ModelAttribute("trabajador") Trabajador trabajador){
        trabajadorServicio.guardarTrabajadores(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/trabajadores/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model modelo){
        modelo.addAttribute("trabajador", trabajadorServicio.getTrabajadorporId(id));
        modelo.addAttribute("titlePage", "Editar usuario");
        return "editar_trabajador";
    }

    @PostMapping("/trabajadores/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("trabajador") Trabajador trabajador) {
        Trabajador trabajador1 = trabajadorServicio.getTrabajadorporId(id);

        trabajador1.setNombre(trabajador.getNombre());
        trabajador1.setApellido(trabajador.getApellido());
        trabajador1.setEmail(trabajador.getEmail());

        trabajadorServicio.actualizarTrabajador(trabajador1);

        return "redirect:/trabajadores";
    }

    @GetMapping("/trabajadores/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        trabajadorServicio.eliminarTrabajador(id);

        return "redirect:/trabajadores";
    }

}
