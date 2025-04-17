package br.com.fiap.prescricaoms.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemPrescricaoDTO {

    @NotNull(message = "O nome do medicamento é obrigatório.")
    private String medicamento;

    @NotNull(message = "A dosagem é obrigatória.")
    private Double dosagem;

    @NotNull(message = "O intervalo de horas é obrigatório.")
    private Integer intervaloHoras;

    private Boolean recorrente; // Campo opcional, não requer validação
}
