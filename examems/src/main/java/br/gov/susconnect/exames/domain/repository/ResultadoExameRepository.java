package br.gov.susconnect.exames.domain.repository;

import br.gov.susconnect.exames.domain.model.ResultadoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoExameRepository extends JpaRepository<ResultadoExame, Long> {
}
