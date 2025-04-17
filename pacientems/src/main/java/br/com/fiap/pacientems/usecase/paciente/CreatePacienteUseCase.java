package br.com.fiap.pacientems.usecase.paciente;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.gateway.PacienteGateway;
import org.springframework.stereotype.Service;

@Service
public class CreatePacienteUseCase {
    
    private final PacienteGateway gateway;

    public CreatePacienteUseCase(PacienteGateway gateway) {
        this.gateway = gateway;
    }

    public Paciente execute(Paciente paciente) {
        if (gateway.existsByCpf(paciente.getCpf())) {
            throw new RuntimeException("Paciente com CPF já cadastrado");
        }
        return gateway.create(paciente);
    }
}
