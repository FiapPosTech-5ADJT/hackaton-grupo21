package br.com.fiap.pacientems.controller;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.dto.PacienteCreateRequestDto;
import br.com.fiap.pacientems.dto.PacientePatchRequestDto;
import br.com.fiap.pacientems.dto.converter.PacienteConverter;
import br.com.fiap.pacientems.usecase.paciente.CreatePacienteUseCase;
import br.com.fiap.pacientems.usecase.paciente.DeletePacienteUseCase;
import br.com.fiap.pacientems.usecase.paciente.GetDataPacienteUseCase;
import br.com.fiap.pacientems.usecase.paciente.PatchPacienteUseCase;
import br.com.fiap.pacientems.exception.PacienteNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Pacientes", description = "API para gerenciamento de pacientes")
public class PacienteController {

    private final CreatePacienteUseCase createPacienteUseCase;
    private final PatchPacienteUseCase patchPacienteUseCase;
    private final DeletePacienteUseCase deletePacienteUseCase;
    private final GetDataPacienteUseCase getDataPacienteUseCase;

    public PacienteController(
            CreatePacienteUseCase createPacienteUseCase,
            PatchPacienteUseCase patchPacienteUseCase,
            DeletePacienteUseCase deletePacienteUseCase,
            GetDataPacienteUseCase getDataPacienteUseCase) {
        this.createPacienteUseCase = createPacienteUseCase;
        this.patchPacienteUseCase = patchPacienteUseCase;
        this.deletePacienteUseCase = deletePacienteUseCase;
        this.getDataPacienteUseCase = getDataPacienteUseCase;
    }

    @PostMapping
    @Operation(summary = "Criar novo paciente", description = "Cria um novo paciente no sistema")
    public ResponseEntity<Paciente> create(@RequestBody PacienteCreateRequestDto dto) {
        var paciente = PacienteConverter.toDomain(dto);
        var createdPaciente = createPacienteUseCase.execute(paciente);
        return ResponseEntity.ok(createdPaciente);
    }

    @GetMapping
    @Operation(summary = "Listar todos os pacientes", description = "Retorna uma lista com todos os pacientes cadastrados")
    public ResponseEntity<List<Paciente>> getAll() {
        var pacientes = getDataPacienteUseCase.execute();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Buscar paciente por CPF", description = "Retorna um paciente específico baseado no CPF fornecido")
    public ResponseEntity<Paciente> getByCpf(@PathVariable String cpf) {
        try {
            var paciente = getDataPacienteUseCase.execute(cpf);
            return paciente.map(ResponseEntity::ok)
                    .orElseThrow(() -> new PacienteNotFoundException(cpf));
        } catch (RuntimeException e) {
            throw new PacienteNotFoundException(cpf);
        }
    }


    @PatchMapping("/{cpf}")
    @Operation(summary = "Atualizar paciente parcialmente", description = "Atualiza apenas os campos fornecidos do paciente")
    public ResponseEntity<Paciente> patch(@PathVariable String cpf, @RequestBody PacientePatchRequestDto dto) {
        try {
            var updatedPaciente = patchPacienteUseCase.execute(cpf, dto);
            return ResponseEntity.ok(updatedPaciente);
        } catch (RuntimeException e) {
            throw new PacienteNotFoundException(cpf);
        }
    }

    @DeleteMapping("/{cpf}")
    @Operation(summary = "Excluir paciente", description = "Remove um paciente do sistema")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        try {
            deletePacienteUseCase.execute(cpf);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            throw new PacienteNotFoundException(cpf);
        }
    }
}
