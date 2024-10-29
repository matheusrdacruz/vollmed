package br.com.dars.api_vollmed.repository;

import br.com.dars.api_vollmed.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String login);
}
