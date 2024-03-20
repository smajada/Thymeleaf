package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrabajadorController {

    private final TrabajadorServicio trabajadorServicio;

    public TrabajadorController(TrabajadorServicio trabajadorServicio) {
        this.trabajadorServicio = trabajadorServicio;
    }

    @GetMapping({"/trabajadores", "/"})
    public String listarTrabajadores(Model modelo){
        modelo.addAttribute("trabajadores", trabajadorServicio.listAllTrabajadores());
        modelo.addAttribute("titlePage", "Listado");
        return "trabajadores";
    }

    @GetMapping("/trabajadores/nuevo")
    public String mostrarTrabajadoresFormulario(Model modelo){
//        Trabajador trabajador = new Trabajador();
//        modelo.addAttribute("trabajador", trabajador);
        modelo.addAttribute("comercial", new Comercial());
        modelo.addAttribute("administrativo", new Administrativo());
        modelo.addAttribute("titlePage", "Nuevo trabajador");
        return "crear_administrativo";
    }

    @PostMapping("/trabajadores")
    public String guardarTrabajador(@RequestParam("tipo") String tipo, @ModelAttribute("administrativo") Administrativo administrativo, @ModelAttribute("comercial") Comercial comercial) {
        if ("administrativo".equals(tipo)) {
            if (administrativo.getId() == null) {
                trabajadorServicio.guardarTrabajadores(administrativo);
            } else {
                trabajadorServicio.actualizarTrabajador(administrativo);
            }
        } else if ("comercial".equals(tipo)) {
            if (comercial.getId() == null) {
                trabajadorServicio.guardarTrabajadores(comercial);
            } else {
                trabajadorServicio.actualizarTrabajador(comercial);
            }
        }

        return "redirect:/trabajadores";
    }


    @GetMapping("/trabajadores/editar/{id}")
    public String editarTrabajador(@PathVariable Long id, Model modelo){
        modelo.addAttribute("trabajador", trabajadorServicio.getTrabajadorporId(id));
        modelo.addAttribute("titlePage", "Editar usuario");
        return "editar_trabajador";
    }

    @PostMapping("/trabajadores/{id}")
    public String actualizarTrabajador(@PathVariable Long id, @ModelAttribute("trabajador") Trabajador trabajador) {
        Trabajador trabajador1 = trabajadorServicio.getTrabajadorporId(id);

        trabajador1.setNombre(trabajador.getNombre());
        trabajador1.setApellido(trabajador.getApellido());
        trabajador1.setEmail(trabajador.getEmail());

        trabajadorServicio.actualizarTrabajador(trabajador1);

        return "redirect:/trabajadores";
    }

    @GetMapping("/trabajadores/{id}")
    public String eliminarTrabajador(@PathVariable Long id){
        trabajadorServicio.eliminarTrabajador(id);

        return "redirect:/trabajadores";
    }

}
