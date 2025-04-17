package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.controller.docs.AllergyControllerDocs;
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

@RestController
@RequestMapping("/alergia")
@AllArgsConstructor
public class AllergyController implements AllergyControllerDocs {

    private final CreateAllergyUseCase createAllergyUseCase;
    private final UpdateAllergyUseCase updateAllergyUseCase;
    private final DeleteAllergyUseCase deleteAllergyUseCase;
    private final GetDataAllergyUseCase getDataAllergyUseCaseUseCase;

    @Override
    public ResponseEntity<Alergia> createAllergy(@RequestBody AllergyCreateRequestDto allergyCreateRequestDto) {
        Alergia alergia = AllergyConverter.toDomain(allergyCreateRequestDto);
        Alergia created = createAllergyUseCase.execute(alergia);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<Void> updateAllergy(@RequestBody AllergyUpdateRequestDto allergyUpdateRequestDto) {
        Alergia alergia = AllergyConverter.toDomain(allergyUpdateRequestDto);
        updateAllergyUseCase.execute(alergia);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllergy(@PathVariable Long id) {
        deleteAllergyUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Alergia>> getAllergies(@PathVariable String cpf) {
        return ResponseEntity.ok(getDataAllergyUseCaseUseCase.execute(cpf));
    }
}
