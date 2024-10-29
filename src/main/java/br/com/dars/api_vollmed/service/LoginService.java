package br.com.dars.api_vollmed.service;


import br.com.dars.api_vollmed.dto.LoginForm;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authManager;

    public LoginService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    public void login(@Valid LoginForm loginForm) {
        var token = new UsernamePasswordAuthenticationToken(loginForm.login(), loginForm.password());
        var authentication = this.authManager.authenticate(token);
    }
}
