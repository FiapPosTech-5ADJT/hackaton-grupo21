package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertJpaRepository extends JpaRepository<AlertaEntity, Long> {
     List<AlertaEntity> findByCpf(String cpf);
}
