package com.example.universidadeAmazonia.controllers;

import com.example.universidadeAmazonia.services.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{ra}/materias")
    public List<Map<String, Object>> listarMateriasPorRa(@PathVariable String ra) {
        return alunoService.listarMateriasPorRa(ra);
    }
}