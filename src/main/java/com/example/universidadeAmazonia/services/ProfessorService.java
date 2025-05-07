package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.repositories.ProfessorRepository;
import com.example.universidadeAmazonia.repositories.MateriaAlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final MateriaAlunoRepository materiaAlunoRepository;

    public ProfessorService(ProfessorRepository professorRepository, MateriaAlunoRepository materiaAlunoRepository) {
        this.professorRepository = professorRepository;
        this.materiaAlunoRepository = materiaAlunoRepository;
    }

    public List<Map<String, Object>> buscarAlunosPorProfessor(Long idProfessor) {
        return professorRepository.listarAlunosPorProfessor(idProfessor);
    }

    public void cadastrarNotas(Long idAluno, Long idMateria, Double np1, Double np2, Double rep, Double exame) {
        materiaAlunoRepository.atualizarNotas(idAluno, idMateria, np1, np2, rep, exame);
    }
}
