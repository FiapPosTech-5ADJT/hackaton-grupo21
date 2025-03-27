package br.com.fiap.oauthms.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Roles role;
    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    @Override
    //TODO implementar o método getAuthorities mais detalhado
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Roles.ADMIN || this.role == Roles.PROFISSIONAL_ATENDIMENTO) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String name, String email, String password, Establishment establishment, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.establishment = establishment;
        this.role = Roles.valueOf(role);
    }
}
