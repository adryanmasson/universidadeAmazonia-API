package com.example.universidadeAmazonia.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.universidadeAmazonia.models.MateriaAluno;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE MateriaAluno ma SET ma.np1 = :np1, ma.np2 = :np2, ma.rep = :rep, ma.exame = :exame " +
            "WHERE ma.idAluno.id = :idAluno AND ma.idMateria.id = :idMateria")
    void atualizarNotas(Long idAluno, Long idMateria, Double np1, Double np2, Double rep, Double exame);

@Query(value = """
    SELECT m.id_materia AS id, m.nome AS nome
    FROM materia m
    JOIN materia_aluno ma ON ma.id_materia = m.id_materia
    JOIN usuario u ON u.id_usuario = ma.id_aluno
    WHERE u.identificador = :ra
""", nativeQuery = true)
List<Map<String, Object>> buscarMateriasPorRaAluno(@Param("ra") String ra);
}
