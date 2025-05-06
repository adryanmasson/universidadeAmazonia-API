package com.example.universidadeAmazonia.controllers;

import com.example.universidadeAmazonia.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{id}/alunos")
    public List<Map<String, Object>> listarAlunosDoProfessor(@PathVariable Long id) {
        return professorService.buscarAlunosPorProfessor(id);
    }
}
