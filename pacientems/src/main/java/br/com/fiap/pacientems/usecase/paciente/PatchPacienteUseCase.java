package br.com.fiap.pacientems.usecase.paciente;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.dto.PacientePatchRequestDto;
import br.com.fiap.pacientems.gateway.PacienteGateway;
import org.springframework.stereotype.Service;

@Service
public class PatchPacienteUseCase {
    
    private final PacienteGateway gateway;

    public PatchPacienteUseCase(PacienteGateway gateway) {
        this.gateway = gateway;
    }

    public Paciente execute(String cpf, PacientePatchRequestDto patchDto) {
        var pacienteExistente = gateway.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        // Atualiza apenas os campos não nulos
        if (patchDto.getNome() != null) {
            pacienteExistente.setNome(patchDto.getNome());
        }
        if (patchDto.getDataNascimento() != null) {
            pacienteExistente.setDataNascimento(patchDto.getDataNascimento());
        }
        if (patchDto.getTelefone() != null) {
            pacienteExistente.setTelefone(patchDto.getTelefone());
        }
        if (patchDto.getEmail() != null) {
            pacienteExistente.setEmail(patchDto.getEmail());
        }
        if (patchDto.getEndereco() != null) {
            pacienteExistente.setEndereco(patchDto.getEndereco());
        }

        return gateway.update(pacienteExistente);
    }
}
