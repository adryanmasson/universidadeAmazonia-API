package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.repositories.MateriaAlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    private final MateriaAlunoRepository materiaAlunoRepository;

    public AlunoService(MateriaAlunoRepository materiaAlunoRepository) {
        this.materiaAlunoRepository = materiaAlunoRepository;
    }

    public List<Map<String, Object>> listarMateriasPorRa(String ra) {
        return materiaAlunoRepository.buscarMateriasPorRaAluno(ra);
    }

    public Map<String, Object> buscarNotasPorMateriaERa(String ra, Long idMateria) {
        return materiaAlunoRepository.buscarNotasEMediaPorRaEMateria(ra, idMateria);
    }
}
