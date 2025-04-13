package br.gov.susconnect.exames.domain.repository;

import br.gov.susconnect.exames.domain.model.TipoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoExameRepository extends JpaRepository<TipoExame, Long> {
}
