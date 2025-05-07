package com.example.universidadeAmazonia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    private Integer idMateria;
    private String nome;

    // Construtores

    public Materia() {
    }

    public Materia(Integer idMateria, String nome) {
        this.idMateria = idMateria;
        this.nome = nome;
    }

    // Getters e Setters

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
