package br.gov.susconnect.exames.domain.repository;

import br.gov.susconnect.exames.domain.model.AgendamentoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoExameRepository extends JpaRepository<AgendamentoExame, Long> {
  List<AgendamentoExame> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
