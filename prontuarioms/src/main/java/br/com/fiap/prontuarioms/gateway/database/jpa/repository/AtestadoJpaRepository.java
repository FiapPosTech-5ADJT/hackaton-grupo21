package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.domain.Atestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtestadoJpaRepository extends JpaRepository<Atestado, Long> {
}
