package br.com.fiap.prescricaoms.repository;

import br.com.fiap.prescricaoms.model.Dispensacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispensacaoRepository extends JpaRepository<Dispensacao, Long> {
    List<Dispensacao> findByPrescricaoId(Long prescricaoId);
}
