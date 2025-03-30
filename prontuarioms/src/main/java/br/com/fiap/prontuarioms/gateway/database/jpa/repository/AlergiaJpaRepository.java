package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.domain.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlergiaJpaRepository extends JpaRepository<Alergia, Long> {
}
