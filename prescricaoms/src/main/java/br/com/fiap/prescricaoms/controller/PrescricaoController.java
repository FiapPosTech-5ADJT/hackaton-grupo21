package br.com.fiap.prescricaoms.controller;

import br.com.fiap.prescricaoms.dto.PrescricaoDTO;
import br.com.fiap.prescricaoms.model.Prescricao;
import br.com.fiap.prescricaoms.service.PrescricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Prescrições")
@RequestMapping("/api/prescricoes")
public class PrescricaoController {

    private final PrescricaoService prescricaoService;

    public PrescricaoController(PrescricaoService prescricaoService) {
        this.prescricaoService = prescricaoService;
    }
    @Operation(summary = "Cadastrar uma nova prescrição")
    @PostMapping
    public ResponseEntity<PrescricaoDTO> cadastrarPrescricao(@RequestBody @Valid PrescricaoDTO prescricaoDTO) {
      return ResponseEntity.ok(prescricaoService.cadastrarPrescricao(prescricaoDTO));
    }
    @Operation(summary = "Consultar prescrições ativas por CPF do paciente")
    @GetMapping("/ativas/{cpfPaciente}")
    public ResponseEntity<List<PrescricaoDTO> > consultarPrescricoesAtivas(@PathVariable String cpfPaciente) {
        return ResponseEntity.ok(prescricaoService.consultarPrescricoesAtivas(cpfPaciente));
    }
    @Operation(summary = "Consultar histórico de prescrições por CPF do paciente")
    @GetMapping("/historico/{cpfPaciente}")
    public ResponseEntity<List<PrescricaoDTO>> consultarHistoricoPrescricoes(@PathVariable String cpfPaciente) {
      return ResponseEntity.ok(prescricaoService.consultarHistoricoPrescricoes(cpfPaciente));
    }
}
