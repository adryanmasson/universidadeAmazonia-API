package com.example.universidadeAmazonia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.universidadeAmazonia.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ProfessorRepository extends JpaRepository<Usuario, Long> {

    @Query(value = """
                SELECT u.id_usuario AS id, u.nome AS nome, u.identificador AS ra
                FROM usuario u
                JOIN materia_aluno ma ON ma.id_aluno = u.id_usuario
                JOIN materia_professor mp ON mp.id_materia = ma.id_materia
                WHERE mp.id_professor = :idProfessor
                AND u.tipo = 'aluno'
            """, nativeQuery = true)
    List<Map<String, Object>> listarAlunosPorProfessor(@Param("idProfessor") Long idProfessor);
}
