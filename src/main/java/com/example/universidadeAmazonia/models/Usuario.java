package com.example.universidadeAmazonia.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @Column(nullable = false, unique = true)
    private String identificador; // RA ou RP

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha; // Senha já hashada (BCrypt)

    protected Usuario() {
    }

    public Usuario(TipoUsuario tipo, String identificador, String nome, String senha) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.nome = nome;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
