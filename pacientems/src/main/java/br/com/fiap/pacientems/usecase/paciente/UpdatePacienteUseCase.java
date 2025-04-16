package br.com.fiap.pacientems.usecase.paciente;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.gateway.PacienteGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdatePacienteUseCase {
    
    private final PacienteGateway gateway;

    public UpdatePacienteUseCase(PacienteGateway gateway) {
        this.gateway = gateway;
    }

    public Paciente execute(String cpf, Paciente paciente) {
        if (!gateway.findByCpf(cpf).isPresent()) {
            throw new RuntimeException("Paciente não encontrado");
        }
        paciente.setCpf(cpf);
        return gateway.update(paciente);
    }
}
