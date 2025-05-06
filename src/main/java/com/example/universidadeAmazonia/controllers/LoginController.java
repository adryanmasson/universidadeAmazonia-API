package com.example.universidadeAmazonia.controllers;

import com.example.universidadeAmazonia.services.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Map<String, Object> login(@RequestBody Map<String, String> request) {
        String identificador = request.get("identificador");
        String senha = request.get("senha");
        return loginService.autenticar(identificador, senha);
    }
}
