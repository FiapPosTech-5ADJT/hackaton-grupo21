package br.com.fiap.prontuarioms.controller;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.dto.AlertCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AlertUpdateRequestDto;
import br.com.fiap.prontuarioms.dto.converter.AlertConverter;
import br.com.fiap.prontuarioms.usecase.alerta.CreateAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.DeleteAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.GetDataAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.UpdateAlertUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alerta")
@AllArgsConstructor
public class AlertController {

    private final CreateAlertUseCase createAlertUseCase;
    private final UpdateAlertUseCase updateAlertUseCase;
    private final DeleteAlertUseCase deleteAlertUseCase;
    private final GetDataAlertUseCase getDataAlertUseCase;

    @PostMapping
    public ResponseEntity<Alerta> createAlert(@RequestBody AlertCreateRequestDto dto) {
        Alerta alerta = AlertConverter.toDomain(dto);
        return ResponseEntity.ok(createAlertUseCase.execute(alerta));
    }

    @PutMapping
    public ResponseEntity<Void> updateAlert(@RequestBody AlertUpdateRequestDto dto) {
        Alerta alerta = AlertConverter.toDomain(dto);
        updateAlertUseCase.execute(alerta);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        deleteAlertUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<Alerta>> getAlerts(@PathVariable String cpf) {
        return ResponseEntity.ok(getDataAlertUseCase.execute(cpf));
    }
}
