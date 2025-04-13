package br.gov.susconnect.exames.infrastructure.rest;

import br.gov.susconnect.exames.application.dto.UnidadeSaudeRequestDTO;
import br.gov.susconnect.exames.application.dto.UnidadeSaudeResponseDTO;
import br.gov.susconnect.exames.application.service.UnidadeSaudeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@Tag(name = "Unidades de Saúde", description = "Operações relacionadas às unidades de saúde")
public class UnidadeSaudeController {

    @Autowired
    private UnidadeSaudeService unidadeSaudeService;

    @Operation(summary = "Listar todas as unidades de saúde")
    @GetMapping
    public ResponseEntity<List<UnidadeSaudeResponseDTO>> listarTodos() {
        return ResponseEntity.ok(unidadeSaudeService.listarTodos());
    }

    @Operation(summary = "Buscar unidade de saúde por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeSaudeResponseDTO> buscarPorId(@PathVariable Long id) {
        UnidadeSaudeResponseDTO unidade = unidadeSaudeService.buscarPorId(id);
        return unidade != null ? ResponseEntity.ok(unidade) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Filtrar unidades de saúde por tipo")
    @GetMapping("/tipo")
    public ResponseEntity<List<UnidadeSaudeResponseDTO>> buscarPorTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(unidadeSaudeService.buscarPorTipo(tipo));
    }

    @Operation(summary = "Filtrar unidades de saúde por estado")
    @GetMapping("/estado")
    public ResponseEntity<List<UnidadeSaudeResponseDTO>> buscarPorEstado(@RequestParam String estado) {
        return ResponseEntity.ok(unidadeSaudeService.buscarPorEstado(estado));
    }

    @Operation(summary = "Filtrar unidades de saúde por cidade")
    @GetMapping("/cidade")
    public ResponseEntity<List<UnidadeSaudeResponseDTO>> buscarPorCidade(@RequestParam String cidade) {
        return ResponseEntity.ok(unidadeSaudeService.buscarPorCidade(cidade));
    }

    @Operation(summary = "Criar uma nova unidade de saúde")
    @PostMapping
    public ResponseEntity<UnidadeSaudeResponseDTO> criar(@RequestBody UnidadeSaudeRequestDTO dto) {
        return ResponseEntity.ok(unidadeSaudeService.salvar(dto));
    }

    @Operation(summary = "Deletar uma unidade de saúde")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        unidadeSaudeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
