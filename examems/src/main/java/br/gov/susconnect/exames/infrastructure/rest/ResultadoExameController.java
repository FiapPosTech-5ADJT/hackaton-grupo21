package br.gov.susconnect.exames.infrastructure.rest;

import br.gov.susconnect.exames.application.dto.ResultadoExameRequestDTO;
import br.gov.susconnect.exames.domain.model.ResultadoExame;
import br.gov.susconnect.exames.application.service.ResultadoExameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resultados")
@Tag(name = "Resultados de Exame", description = "Operações relacionadas aos resultados de exames")
public class ResultadoExameController {

    @Autowired
    private ResultadoExameService resultadoExameService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload de resultado de exame")
    public ResponseEntity<ResultadoExame> uploadResultado(
      @RequestParam("idAgendamento") Long idAgendamento,
      @RequestParam("arquivoResultado")
      @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
      ) MultipartFile arquivoResultado,
      @RequestParam(value = "observacoes", required = false) String observacoes) {

      ResultadoExameRequestDTO dto = new ResultadoExameRequestDTO();
      dto.setIdAgendamento(idAgendamento);
      dto.setArquivoResultado(arquivoResultado);
      dto.setObservacoes(observacoes);

      ResultadoExame resultado = resultadoExameService.salvarResultado(dto);
      return ResponseEntity.ok(resultado);
    }
}
