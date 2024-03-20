package com.smajada.thymeleaf.demo.controller;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CRUDController {

    private final TrabajadorServicio trabajadorServicio;

    public CRUDController(TrabajadorServicio trabajadorServicio) {
        this.trabajadorServicio = trabajadorServicio;
    }

    @GetMapping("/trabajador")
    public List<Trabajador> getAll(){return trabajadorServicio.listAllTrabajadores();}

    @GetMapping("/trabajador/{id}")
    public Trabajador getById(@PathVariable Long id) {return trabajadorServicio.getTrabajadorporId(id);}


    @PostMapping("/trabajador")
    public Trabajador crearEmpleado(@RequestBody Map<String, Object> empleadoData) {
        String tipoEmpleado = (String) empleadoData.get("trabajador_type");

        switch (tipoEmpleado) {
            case "ADMINISTRATIVO":
                Administrativo administrativo = new Administrativo();
                administrativo.setNombre((String) empleadoData.get("nombre"));
                administrativo.setApellido((String) empleadoData.get("apellido"));
                administrativo.setEmail((String) empleadoData.get("email"));
                administrativo.setDepartamento((String) empleadoData.get("departamento"));

                return trabajadorServicio.guardarTrabajadores(administrativo);
            case "COMERCIAL":
                Comercial comercial = new Comercial();
                comercial.setNombre((String) empleadoData.get("nombre"));
                comercial.setApellido((String) empleadoData.get("apellido"));
                comercial.setEmail((String) empleadoData.get("email"));
                comercial.setObjetivoVentasMensuales((Integer) empleadoData.get("objetivoVentasMensuales"));

                return trabajadorServicio.guardarTrabajadores(comercial);

            default:
                throw new IllegalArgumentException("Tipo de empleado no válido: " + tipoEmpleado);
        }
    }


}
