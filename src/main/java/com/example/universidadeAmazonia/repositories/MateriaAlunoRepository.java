package com.example.universidadeAmazonia.repositories;

import com.example.universidadeAmazonia.models.MateriaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {

    @Query(value = """
                SELECT m.id_materia AS id, m.nome AS nome
                FROM materia m
                JOIN materia_aluno ma ON ma.id_materia = m.id_materia
                JOIN usuario u ON u.id_usuario = ma.id_aluno
                WHERE u.identificador = :ra
            """, nativeQuery = true)
    List<Map<String, Object>> buscarMateriasPorRaAluno(@Param("ra") String ra);

    @Query(value = """
                SELECT
                    m.nome AS materia,
                    ma.np1,
                    ma.np2,
                    ma.rep,
                    ma.exame,
                    COALESCE(ma.rep, (ma.np1 + ma.np2) / 2) AS media,
                    prof.nome AS professor
                FROM materia_aluno ma
                JOIN usuario aluno ON aluno.id_usuario = ma.id_aluno
                JOIN materia m ON m.id_materia = ma.id_materia
                JOIN materia_professor mp ON mp.id_materia = m.id_materia
                JOIN usuario prof ON prof.id_usuario = mp.id_professor
                WHERE aluno.identificador = :ra
                  AND m.id_materia = :idMateria
                LIMIT 1
            """, nativeQuery = true)
    Map<String, Object> buscarNotasEMediaPorRaEMateria(@Param("ra") String ra,
            @Param("idMateria") Long idMateria);

    @Query("SELECT ma FROM MateriaAluno ma WHERE ma.idAluno.id = :idAluno AND ma.idMateria.id = :idMateria")
    MateriaAluno findByIdAlunoAndIdMateria(@Param("idAluno") Long idAluno, @Param("idMateria") Long idMateria);

    @Override
    <S extends MateriaAluno> S save(S entity);
}
