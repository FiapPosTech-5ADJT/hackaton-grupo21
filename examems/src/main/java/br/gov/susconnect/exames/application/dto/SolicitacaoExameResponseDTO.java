package br.gov.susconnect.exames.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitacaoExameResponseDTO {
    private Long id;
    private String idPaciente;
    private String idProfissional;
    private LocalDateTime dataSolicitacao;
    private boolean urgente;
    private TipoExameResponseDTO tipoExame;
}
