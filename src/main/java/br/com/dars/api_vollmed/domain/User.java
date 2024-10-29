package br.com.dars.api_vollmed.domain;

import br.com.dars.api_vollmed.dto.UserForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean active = true;

    public User(UserForm userForm) {
        this.name = userForm.name();
        this.username = userForm.username();
        this.email = userForm.email();
        this.password = userForm.password();
    }
}
