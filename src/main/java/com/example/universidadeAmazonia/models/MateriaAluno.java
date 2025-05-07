package com.example.universidadeAmazonia.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materia_aluno")
@Getter
@Setter
public class MateriaAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_aluno")
    private Long idMateriaAluno;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Usuario idAluno;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia idMateria;

    private Double np1;
    private Double np2;
    private Double rep;
    private Double exame;
}
