package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.controller.docs.VaccineControllerDocs;
import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.dto.VaccineCreateRequestDto;
import br.com.fiap.prontuarioms.dto.VaccineUpdateRequestDto;
import br.com.fiap.prontuarioms.dto.converter.VaccineConverter;
import br.com.fiap.prontuarioms.usecase.vacina.CreateVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.DeleteVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.GetDataVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.UpdateVaccineUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacina")
@AllArgsConstructor
public class VaccineController implements VaccineControllerDocs {

    private final CreateVaccineUseCase createUseCase;
    private final UpdateVaccineUseCase updateUseCase;
    private final DeleteVaccineUseCase deleteUseCase;
    private final GetDataVaccineUseCase getDataUseCase;

    @Override
    public ResponseEntity<Vacina> create(@RequestBody VaccineCreateRequestDto dto) {
        Vacina vacina = VaccineConverter.toDomain(dto);
        return ResponseEntity.ok(createUseCase.execute(vacina));
    }

    @Override
    public ResponseEntity<Void> update(@RequestBody VaccineUpdateRequestDto dto) {
        Vacina vacina = VaccineConverter.toDomain(dto);
        updateUseCase.execute(vacina);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Vacina>> getAll(@PathVariable String cpf) {
        return ResponseEntity.ok(getDataUseCase.execute(cpf));
    }
}
