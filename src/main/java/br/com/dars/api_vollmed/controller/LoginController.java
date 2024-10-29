package br.com.dars.api_vollmed.controller;

import br.com.dars.api_vollmed.dto.LoginForm;
import br.com.dars.api_vollmed.service.AuthService;
import br.com.dars.api_vollmed.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginForm loginForm) {
        loginService.login(loginForm);
        return ResponseEntity.ok().build();
    }
}
