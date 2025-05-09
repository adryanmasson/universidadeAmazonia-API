package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.models.MateriaAluno;
import com.example.universidadeAmazonia.models.Materia;
import com.example.universidadeAmazonia.models.Usuario;
import com.example.universidadeAmazonia.repositories.MateriaAlunoRepository;
import com.example.universidadeAmazonia.repositories.MateriaRepository;
import com.example.universidadeAmazonia.repositories.ProfessorRepository;
import com.example.universidadeAmazonia.repositories.UsuarioRepository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final MateriaAlunoRepository materiaAlunoRepository;
    private final UsuarioRepository usuarioRepository;
    private final MateriaRepository materiaRepository;
    private ProfessorRepository professorRepository;

    public ProfessorService(MateriaAlunoRepository materiaAlunoRepository, UsuarioRepository usuarioRepository,
            MateriaRepository materiaRepository, ProfessorRepository professorRepository) {
        this.materiaAlunoRepository = materiaAlunoRepository;
        this.usuarioRepository = usuarioRepository;
        this.materiaRepository = materiaRepository;
        this.professorRepository = professorRepository;
    }

    public List<Map<String, Object>> buscarAlunosPorProfessor(Long idProfessor) {
        return professorRepository.listarAlunosPorProfessor(idProfessor);
    }

    public void cadastrarNotas(Long idAluno, Long idMateria, Double np1, Double np2, Double rep, Double exame) {
        Usuario aluno = usuarioRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Materia materia = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada"));

        MateriaAluno materiaAluno = materiaAlunoRepository.findByIdAlunoAndIdMateria(idAluno, idMateria);

        if (materiaAluno == null) {
            materiaAluno = new MateriaAluno();
            materiaAluno.setIdAluno(aluno);
            materiaAluno.setIdMateria(materia);
        }

        materiaAluno.setNp1(np1);
        materiaAluno.setNp2(np2);
        materiaAluno.setRep(rep);
        materiaAluno.setExame(exame);

        materiaAlunoRepository.save(materiaAluno);
    }

}
