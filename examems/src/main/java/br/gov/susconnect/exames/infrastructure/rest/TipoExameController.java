package br.gov.susconnect.exames.infrastructure.rest;

import br.gov.susconnect.exames.application.dto.TipoExameRequestDTO;
import br.gov.susconnect.exames.application.dto.TipoExameResponseDTO;
import br.gov.susconnect.exames.application.service.TipoExameService;
import br.gov.susconnect.exames.domain.model.TipoExame;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipos-exame")
@Tag(name = "Tipos Exames", description = "Operações relacionadas aos tipos de exames")
public class TipoExameController {

  @Autowired
  private TipoExameService tipoExameService;
  @Operation(summary = "Create a new TipoExame")
  @PostMapping
  public ResponseEntity<TipoExameResponseDTO> criarTipoExame(@RequestBody TipoExameRequestDTO tipoExameDTO) {
    TipoExameResponseDTO novoTipoExame = tipoExameService.salvar(tipoExameDTO);
    return ResponseEntity.ok(novoTipoExame);
  }

  @GetMapping
  public ResponseEntity<List<TipoExameResponseDTO>> listarTiposExame() {
    List<TipoExameResponseDTO> tiposExameDTO = tipoExameService.listarTodos().stream()
      .map(tipoExameService::convertToDTO)
      .collect(Collectors.toList());
    return ResponseEntity.ok(tiposExameDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TipoExameResponseDTO> buscarTipoExamePorId(@PathVariable Long id) {
    TipoExame tipoExame = tipoExameService.buscarPorId(id);
    if (tipoExame != null) {
      TipoExameResponseDTO dto = tipoExameService.convertToDTO(tipoExame);
      return ResponseEntity.ok(dto);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarTipoExame(@PathVariable Long id) {
    tipoExameService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
