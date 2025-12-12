package com.ipn.Ejercicio1.controller;

import com.ipn.Ejercicio1.model.ProgramaAcademico;
import com.ipn.Ejercicio1.repository.ProgramaAcademicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaAcademicoRepository repo;

    public ProgramaController(ProgramaAcademicoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ProgramaAcademico> getAll() {
        return repo.findAll();
    }
}
