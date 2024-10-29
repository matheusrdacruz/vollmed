package br.com.dars.api_vollmed.service;

import br.com.dars.api_vollmed.domain.User;
import br.com.dars.api_vollmed.dto.UserForm;
import br.com.dars.api_vollmed.dto.UserView;
import br.com.dars.api_vollmed.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserView findByLogin(String login) {
        var user = this.findByEmailOrUsername(login);
        if (user == null) {
            return null;
        }
        return new UserView(user);
    }

    protected User findByEmailOrUsername(String login) {
        var user = this.userRepository.findByEmail(login);
        return (user != null) ? user : this.userRepository.findByUsername(login);
    }

    public UserView create(UserForm userform) {
        if (userform == null) {
            return null;
        }
        this.validation(userform);
        var user = new User(userform);
        return new UserView(this.userRepository.save(user));
    }

    private void validation(UserForm user) throws RuntimeException {
        if (user == null) {
            throw new RuntimeException("Dados inexistentes.");
        }
        if (!user.email().equalsIgnoreCase(user.emailConfirmation())) {
            throw new RuntimeException("Os emails devem ser iguais.");
        }

        if (!user.password().equalsIgnoreCase(user.passwordConfirmation())) {
            throw new RuntimeException("As senhas devem ser iguais.");
        }
    }
}
