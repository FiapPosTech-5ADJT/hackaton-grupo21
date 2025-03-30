package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.domain.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaJpaRepository extends JpaRepository<Alerta, Long> {
}
