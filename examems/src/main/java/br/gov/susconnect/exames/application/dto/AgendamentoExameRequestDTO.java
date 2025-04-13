package br.gov.susconnect.exames.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoExameRequestDTO {
    private Long idSolicitacao;
    private Long idUnidadeSaude;
    private LocalDateTime dataHora;
}
