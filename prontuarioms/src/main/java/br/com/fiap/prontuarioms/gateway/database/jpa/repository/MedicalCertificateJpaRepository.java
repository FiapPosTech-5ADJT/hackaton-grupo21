package br.com.fiap.prontuarioms.gateway.database.jpa.repository;

import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AtestadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalCertificateJpaRepository extends JpaRepository<AtestadoEntity, Long> {
    List<AtestadoEntity> findByCpf(String cpf);
}
