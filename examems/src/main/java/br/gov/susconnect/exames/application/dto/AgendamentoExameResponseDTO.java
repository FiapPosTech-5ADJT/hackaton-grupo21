package br.gov.susconnect.exames.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoExameResponseDTO {
  private Long id;
  private SolicitacaoExameResponseDTO solicitacaoExame;
  private UnidadeSaudeResponseDTO unidadeSaude;
  private LocalDateTime dataHora;
  private String status;
}
