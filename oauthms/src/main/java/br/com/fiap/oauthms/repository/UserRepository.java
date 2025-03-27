package br.com.fiap.oauthms.repository;

import br.com.fiap.oauthms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<UserDetails> findByEmail(String email);
}
