package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.dto.MedicalCertificateCreateRequestDto;
import br.com.fiap.prontuarioms.dto.MedicalCertificateUpdateRequestDto;
import br.com.fiap.prontuarioms.dto.converter.MedicalCertificateConverter;
import br.com.fiap.prontuarioms.usecase.atestado.CreateMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.DeleteMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.GetDataMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.UpdateMedicalCertificateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/atestado")
@AllArgsConstructor
public class MedicalCertificateController {

    private final CreateMedicalCertificateUseCase createUseCase;
    private final UpdateMedicalCertificateUseCase updateUseCase;
    private final DeleteMedicalCertificateUseCase deleteUseCase;
    private final GetDataMedicalCertificateUseCase getDataUseCase;

    @PostMapping
    public ResponseEntity<Atestado> create(@RequestBody MedicalCertificateCreateRequestDto dto) {
        Atestado atestado = MedicalCertificateConverter.toDomain(dto);
        return ResponseEntity.ok(createUseCase.execute(atestado));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MedicalCertificateUpdateRequestDto dto) {
        Atestado atestado = MedicalCertificateConverter.toDomain(dto);
        updateUseCase.execute(atestado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<Atestado>> getAll(@PathVariable String cpf) {
        return ResponseEntity.ok(getDataUseCase.execute(cpf));
    }
}
