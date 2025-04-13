package br.gov.susconnect.exames.infrastructure.rest;

import br.gov.susconnect.exames.application.dto.SolicitacaoExameDTO;
import br.gov.susconnect.exames.application.dto.SolicitacaoExameResponseDTO;
import br.gov.susconnect.exames.application.service.SolicitacaoExameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitacoes-exame")
@Tag(name = "Solicitações de Exame", description = "Operações relacionadas às solicitações de exame")
public class SolicitacaoExameController {

    @Autowired
    private SolicitacaoExameService solicitacaoExameService;

    @Operation(summary = "Criar uma nova solicitação de exame")
    @PostMapping
    public ResponseEntity<SolicitacaoExameDTO> criarSolicitacao(@RequestBody SolicitacaoExameDTO dto) {
        SolicitacaoExameDTO novaSolicitacao = solicitacaoExameService.salvar(dto);
        return ResponseEntity.ok(novaSolicitacao);
    }

    @Operation(summary = "Listar todas as solicitações de exame")
    @GetMapping
    public ResponseEntity<List<SolicitacaoExameResponseDTO>> listarSolicitacoes() {
        List<SolicitacaoExameResponseDTO> solicitacoes = solicitacaoExameService.listarTodos();
        return ResponseEntity.ok(solicitacoes);
    }

    @Operation(summary = "Buscar solicitações de exame por CPF do paciente")
    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<SolicitacaoExameResponseDTO>> buscarPorCpfPaciente(@PathVariable String cpf) {
      List<SolicitacaoExameResponseDTO> solicitacoes = solicitacaoExameService.buscarPorCpfPaciente(cpf);
      return ResponseEntity.ok(solicitacoes);
    }
}
