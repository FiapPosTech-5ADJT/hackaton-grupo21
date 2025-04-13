package br.gov.susconnect.exames.domain.repository;

import br.gov.susconnect.exames.domain.model.UnidadeSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, Long> {
    List<UnidadeSaude> findByTipo(String tipo);
    List<UnidadeSaude> findByEstado(String estado);
    List<UnidadeSaude> findByCidade(String cidade);
}
