package br.com.fiap.pacientems.usecase.paciente;

import br.com.fiap.pacientems.gateway.PacienteGateway;
import org.springframework.stereotype.Service;

@Service
public class DeletePacienteUseCase {
    
    private final PacienteGateway gateway;

    public DeletePacienteUseCase(PacienteGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(String cpf) {
        if (!gateway.findByCpf(cpf).isPresent()) {
            throw new RuntimeException("Paciente não encontrado");
        }
        gateway.deleteByCpf(cpf);
    }
}
