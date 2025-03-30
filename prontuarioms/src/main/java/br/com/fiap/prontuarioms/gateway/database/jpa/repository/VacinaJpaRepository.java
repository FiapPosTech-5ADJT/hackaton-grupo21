package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaJpaRepository extends JpaRepository<Vacina, Long> {
}
