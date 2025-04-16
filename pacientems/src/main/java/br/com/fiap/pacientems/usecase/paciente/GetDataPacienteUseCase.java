package br.com.fiap.pacientems.usecase.paciente;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.gateway.PacienteGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDataPacienteUseCase {
    
    private final PacienteGateway gateway;

    public GetDataPacienteUseCase(PacienteGateway gateway) {
        this.gateway = gateway;
    }

    public List<Paciente> execute() {
        return gateway.findAll();
    }

    public Optional<Paciente> execute(String cpf) {
        return gateway.findByCpf(cpf);
    }
}
