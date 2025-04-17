package br.com.fiap.pacientems.gateway.database.jpa.repository;

import br.com.fiap.pacientems.gateway.database.jpa.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteEntity, String> {
    boolean existsByCpf(String cpf);
}
