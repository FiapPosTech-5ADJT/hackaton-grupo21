package br.com.fiap.pacientems.gateway;

import br.com.fiap.pacientems.domain.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteGateway {
    Paciente create(Paciente paciente);
    Optional<Paciente> findByCpf(String cpf);
    List<Paciente> findAll();
    void deleteByCpf(String cpf);
    Paciente update(Paciente paciente);
    boolean existsByCpf(String cpf);
}
