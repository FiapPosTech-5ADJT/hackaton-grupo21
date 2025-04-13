package br.gov.susconnect.exames.domain.repository;

import br.gov.susconnect.exames.domain.model.SolicitacaoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoExameRepository extends JpaRepository<SolicitacaoExame, Long> {
  List<SolicitacaoExame> findByIdPaciente(String cpf);
}
