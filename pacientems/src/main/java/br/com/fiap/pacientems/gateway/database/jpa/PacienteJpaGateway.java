package br.com.fiap.pacientems.gateway.database.jpa;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.dto.converter.PacienteConverter;
import br.com.fiap.pacientems.gateway.PacienteGateway;
import br.com.fiap.pacientems.gateway.database.jpa.repository.PacienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PacienteJpaGateway implements PacienteGateway {

    private final PacienteJpaRepository repository;

    public PacienteJpaGateway(PacienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Paciente create(Paciente paciente) {
        var entity = PacienteConverter.toEntity(paciente);
        var savedEntity = repository.save(entity);
        return PacienteConverter.toDomain(savedEntity);
    }

    @Override
    public Optional<Paciente> findByCpf(String cpf) {
        return repository.findById(cpf)
                .map(PacienteConverter::toDomain);
    }

    @Override
    public List<Paciente> findAll() {
        return repository.findAll().stream()
                .map(PacienteConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByCpf(String cpf) {
        repository.deleteById(cpf);
    }

    @Override
    public Paciente update(Paciente paciente) {
        var entity = PacienteConverter.toEntity(paciente);
        var savedEntity = repository.save(entity);
        return PacienteConverter.toDomain(savedEntity);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
