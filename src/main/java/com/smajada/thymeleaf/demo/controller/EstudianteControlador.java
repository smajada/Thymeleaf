package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Estudiante;
import com.smajada.thymeleaf.demo.service.EstudianteServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", estudianteServicio.listAllEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String mostrarEstudianteFormulario(Model modelo){
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", estudianteServicio.getEstudianteporId(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante) {
        Estudiante estudiante1 = estudianteServicio.getEstudianteporId(id);

        estudiante1.setNombre(estudiante.getNombre());
        estudiante1.setApellido(estudiante.getApellido());
        estudiante1.setEmail(estudiante.getEmail());

        estudianteServicio.actualizarEstudiante(estudiante1);

        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteServicio.eliminarEstudiante(id);

        return "redirect:/estudiantes";
    }

}
