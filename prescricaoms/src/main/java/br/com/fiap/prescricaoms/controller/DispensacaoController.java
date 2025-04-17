package br.com.fiap.prescricaoms.controller;

import br.com.fiap.prescricaoms.dto.DispensacaoDTO;
import br.com.fiap.prescricaoms.model.Dispensacao;
import br.com.fiap.prescricaoms.service.DispensacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispensacoes")
@Tag(name = "Dispensações")
public class DispensacaoController {

    private final DispensacaoService dispensacaoService;

    public DispensacaoController(DispensacaoService dispensacaoService) {
        this.dispensacaoService = dispensacaoService;
    }
    @Operation(summary = "Cadastrar uma nova dispensação")
    @PostMapping
    public ResponseEntity<DispensacaoDTO> cadastrarDispensacao(@RequestBody DispensacaoDTO dispensacaoDTO) {
        return ResponseEntity.ok(dispensacaoService.cadastrarDispensacao(dispensacaoDTO));
    }
    @Operation(summary = "Consultar dispensações por prescrição")
    @GetMapping("/prescricao/{prescricaoId}")
    public ResponseEntity<List<DispensacaoDTO>> consultarDispensacoesPorPrescricao(@PathVariable Long prescricaoId) {
        return ResponseEntity.ok(dispensacaoService.consultarDispensacoesPorPrescricao(prescricaoId));
    }
}
