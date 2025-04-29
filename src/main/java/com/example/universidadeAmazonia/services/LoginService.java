package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.models.Aluno;
import com.example.universidadeAmazonia.models.Professor;
import com.example.universidadeAmazonia.models.Usuario;
import com.example.universidadeAmazonia.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String autenticar(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);

        if (usuarioOpt.isEmpty()) {
            return "Credenciais inválidas";
        }

        Usuario usuario = usuarioOpt.get();

        if (usuario instanceof Aluno) {
            return "aluno";
        } else if (usuario instanceof Professor) {
            return "professor";
        } else {
            return "tipo_desconhecido";
        }
    }
}
