package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Map<String, Object>> buscarAlunosPorProfessor(Long idProfessor) {
        return professorRepository.listarAlunosPorProfessor(idProfessor);
    }
}
