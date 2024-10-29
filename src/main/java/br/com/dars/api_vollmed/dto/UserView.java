package br.com.dars.api_vollmed.dto;

import br.com.dars.api_vollmed.domain.User;

public record UserView(String name, String email, String username) {
    public UserView(User user) {
        this(user.getName(), user.getEmail(), user.getUsername());
    }
}
