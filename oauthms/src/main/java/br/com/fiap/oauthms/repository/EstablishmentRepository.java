package br.com.fiap.oauthms.repository;

import br.com.fiap.oauthms.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
}
