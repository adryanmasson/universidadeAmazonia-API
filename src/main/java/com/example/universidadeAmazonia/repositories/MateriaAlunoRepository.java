package com.example.universidadeAmazonia.repositories;

import com.example.universidadeAmazonia.models.MateriaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE MateriaAluno ma SET ma.np1 = :np1, ma.np2 = :np2, ma.rep = :rep, ma.exame = :exame " +
            "WHERE ma.idAluno.id = :idAluno AND ma.idMateria.id = :idMateria")
    void atualizarNotas(Long idAluno, Long idMateria, Double np1, Double np2, Double rep, Double exame);
}
