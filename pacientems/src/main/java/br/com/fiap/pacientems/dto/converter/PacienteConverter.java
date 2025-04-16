package br.com.fiap.pacientems.dto.converter;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.dto.PacienteCreateRequestDto;
import br.com.fiap.pacientems.dto.PacienteUpdateRequestDto;
import br.com.fiap.pacientems.gateway.database.jpa.entity.PacienteEntity;

public class PacienteConverter {
    
    public static Paciente toDomain(PacienteEntity entity) {
        return new Paciente(
            entity.getCpf(),
            entity.getNome(),
            entity.getDataNascimento(),
            entity.getTelefone(),
            entity.getEmail(),
            entity.getEndereco()
        );
    }

    public static Paciente toDomain(PacienteCreateRequestDto dto) {
        return new Paciente(
            dto.getCpf(),
            dto.getNome(),
            dto.getDataNascimento(),
            dto.getTelefone(),
            dto.getEmail(),
            dto.getEndereco()
        );
    }

    public static Paciente toDomain(String cpf, PacienteUpdateRequestDto dto) {
        return new Paciente(
            cpf,
            dto.getNome(),
            dto.getDataNascimento(),
            dto.getTelefone(),
            dto.getEmail(),
            dto.getEndereco()
        );
    }

    public static PacienteEntity toEntity(Paciente domain) {
        PacienteEntity entity = new PacienteEntity();
        entity.setCpf(domain.getCpf());
        entity.setNome(domain.getNome());
        entity.setDataNascimento(domain.getDataNascimento());
        entity.setTelefone(domain.getTelefone());
        entity.setEmail(domain.getEmail());
        entity.setEndereco(domain.getEndereco());
        return entity;
    }
}
