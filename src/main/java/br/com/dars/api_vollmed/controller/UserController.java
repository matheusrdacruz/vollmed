package br.com.dars.api_vollmed.controller;

import br.com.dars.api_vollmed.dto.UserForm;
import br.com.dars.api_vollmed.dto.UserView;
import br.com.dars.api_vollmed.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserView> findUserByLogin(@PathVariable String login) {
        var user = userService.findByLogin(login);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserView> createUser(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
        var user = this.userService.create(userForm);
        var uri = uriBuilder.path("/users/{login}").buildAndExpand(user.username()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
