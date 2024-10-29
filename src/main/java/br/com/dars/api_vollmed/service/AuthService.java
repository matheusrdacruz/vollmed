package br.com.dars.api_vollmed.service;

import br.com.dars.api_vollmed.infra.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = this.userService.findByEmailOrUsername(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return new UserDetailsImpl(user.getActive(), user.getUsername(), user.getPassword());
    }

}
