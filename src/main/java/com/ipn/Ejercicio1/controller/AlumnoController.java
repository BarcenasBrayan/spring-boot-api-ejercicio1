package com.ipn.Ejercicio1.controller;

import com.ipn.Ejercicio1.model.Alumno;
import com.ipn.Ejercicio1.repository.AlumnoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoRepository repo;

    public AlumnoController(AlumnoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Alumno> getAll() {
        return repo.findAll();
    }
}
