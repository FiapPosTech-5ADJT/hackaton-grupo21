package br.gov.susconnect.exames.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoExameRequestDTO {

  private String nome;
  private String descricao;
  private String preparoNecessario;
  private Integer prazoEntrega;
}
