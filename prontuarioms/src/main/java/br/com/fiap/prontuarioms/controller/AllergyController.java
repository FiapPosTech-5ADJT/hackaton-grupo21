package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.dto.AllergyCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AllergyUpdateRequestDto;
import br.com.fiap.prontuarioms.dto.converter.AllergyConverter;
import br.com.fiap.prontuarioms.usecase.alergia.CreateAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.DeleteAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.GetDataAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.UpdateAllergyUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alergia")
@AllArgsConstructor
public class AllergyController {

    private final CreateAllergyUseCase createAllergyUseCase;
    private final UpdateAllergyUseCase updateAllergyUseCase;
    private final DeleteAllergyUseCase deleteAllergyUseCase;
    private final GetDataAllergyUseCase getDataAllergyUseCaseUseCase;

    @PostMapping
    public ResponseEntity<Alergia> createAllergy(AllergyCreateRequestDto allergyCreateRequestDto) {
        Alergia alergia =  AllergyConverter.toDomain(allergyCreateRequestDto);
        Alergia created = createAllergyUseCase.execute(alergia);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<Void> updateAllergy(AllergyUpdateRequestDto allergyUpdateRequestDto) {
        Alergia alergia = AllergyConverter.toDomain(allergyUpdateRequestDto);
        updateAllergyUseCase.execute(alergia);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllergy(Long id) {
        deleteAllergyUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Alergia>> getAllergies(String cpf) {
        return ResponseEntity.ok(getDataAllergyUseCaseUseCase.execute(cpf));
    }
}
