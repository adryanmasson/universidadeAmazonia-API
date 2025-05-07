package com.example.universidadeAmazonia.controllers;

import com.example.universidadeAmazonia.services.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notas")
public class MateriaAlunoController {

    private final ProfessorService professorService;

    public MateriaAlunoController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarNotas(@RequestBody Map<String, Object> body) {
        // Extraindo os parâmetros do corpo JSON
        Long idAluno = Long.valueOf(body.get("idAluno").toString());
        Long idMateria = Long.valueOf(body.get("idMateria").toString());
        Double np1 = Double.valueOf(body.get("np1").toString());
        Double np2 = Double.valueOf(body.get("np2").toString());
        Double rep = body.containsKey("rep") ? Double.valueOf(body.get("rep").toString()) : null;
        Double exame = body.containsKey("exame") ? Double.valueOf(body.get("exame").toString()) : null;

        professorService.cadastrarNotas(idAluno, idMateria, np1, np2, rep, exame);

        return ResponseEntity.ok("Notas cadastradas com sucesso!");
    }
}
