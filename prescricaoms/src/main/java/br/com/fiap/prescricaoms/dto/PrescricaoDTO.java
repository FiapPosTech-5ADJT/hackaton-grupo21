package br.com.fiap.prescricaoms.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class PrescricaoDTO {

  @NotBlank(message = "O CPF do paciente é obrigatório.")
  private String cpfPaciente;

  @NotBlank(message = "O CPF do profissional é obrigatório.")
  private String cpfProfissional;

  @NotNull(message = "A data é obrigatória.")
  private LocalDate data;

  private List<ItemPrescricaoDTO> itens; // Representação dos itens da prescrição
}
