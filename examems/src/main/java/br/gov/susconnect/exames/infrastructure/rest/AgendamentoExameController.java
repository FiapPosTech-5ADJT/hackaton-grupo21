package br.gov.susconnect.exames.infrastructure.rest;

import br.gov.susconnect.exames.application.dto.AgendamentoExameRequestDTO;
import br.gov.susconnect.exames.application.dto.AgendamentoExameResponseDTO;
import br.gov.susconnect.exames.application.service.AgendamentoExameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@Tag(name = "Agendamentos de Exame", description = "Operações relacionadas aos agendamentos de exame")
public class AgendamentoExameController {

    @Autowired
    private AgendamentoExameService agendamentoExameService;

    @Operation(summary = "Agendar um exame")
    @PostMapping
    public ResponseEntity<AgendamentoExameResponseDTO> agendar(@RequestBody AgendamentoExameRequestDTO dto) {
        AgendamentoExameResponseDTO response = agendamentoExameService.agendar(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cancelar um agendamento")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        agendamentoExameService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Buscar agendamentos por período")
    @GetMapping("/periodo")
    public ResponseEntity<List<AgendamentoExameResponseDTO>> buscarPorPeriodo(
      @RequestParam("inicio") String inicio,
      @RequestParam("fim") String fim) {
      List<AgendamentoExameResponseDTO> agendamentos = agendamentoExameService.buscarPorPeriodo(inicio, fim);
      return ResponseEntity.ok(agendamentos);
    }
}
