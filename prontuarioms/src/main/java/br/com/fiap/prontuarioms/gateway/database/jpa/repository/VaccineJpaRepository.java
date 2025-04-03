package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.gateway.database.jpa.entity.VacinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VaccineJpaRepository extends JpaRepository<VacinaEntity, Long> {
    List<VacinaEntity> findByCpf(String cpf);
}
