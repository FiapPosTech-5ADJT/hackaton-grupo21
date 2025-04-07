package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.dto.VaccineCreateRequestDto;
import br.com.fiap.prontuarioms.dto.converter.VaccineConverter;
import br.com.fiap.prontuarioms.usecase.vacina.CreateVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.DeleteVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.GetDataVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.UpdateVaccineUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacina")
@AllArgsConstructor
public class VaccineController {

    private final CreateVaccineUseCase createUseCase;
    private final UpdateVaccineUseCase updateUseCase;
    private final DeleteVaccineUseCase deleteUseCase;
    private final GetDataVaccineUseCase getDataUseCase;

    @PostMapping
    public ResponseEntity<Vacina> create(VaccineCreateRequestDto dto) {
        Vacina vacina = VaccineConverter.toDomain(dto);
        return ResponseEntity.ok(createUseCase.execute(vacina));
    }

    @PutMapping
    public ResponseEntity<Void> update(Vacina vacina) {
        updateUseCase.execute(vacina);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> getAll(String cpf) {
        return ResponseEntity.ok(getDataUseCase.execute(cpf));
    }
}
