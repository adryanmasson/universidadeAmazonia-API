package com.example.universidadeAmazonia.services;

import com.example.universidadeAmazonia.models.Usuario;
import com.example.universidadeAmazonia.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Injetando o PasswordEncoder
    public LoginService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<String, Object> autenticar(String identificador, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdentificador(identificador);

        if (usuarioOpt.isEmpty()) {
            return Map.of("erro", "Credenciais inválidas");
        }

        Usuario usuario = usuarioOpt.get();

        // Verificando a senha com o PasswordEncoder
        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            return Map.of("erro", "Credenciais inválidas");
        }

        return Map.of(
                "id", usuario.getId(),
                "identificador", usuario.getIdentificador(),
                "nome", usuario.getNome(),
                "tipo", usuario.getTipo().toString());
    }
}
