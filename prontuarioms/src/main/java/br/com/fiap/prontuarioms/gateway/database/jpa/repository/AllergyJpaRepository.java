package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AlergiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AllergyJpaRepository extends JpaRepository<AlergiaEntity, Long> {
     List<AlergiaEntity> findByCpf(String cpf);
}
