package br.com.fiap.prescricaoms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class DispensacaoDTO {

    @NotNull
    private LocalDateTime dataRetirada;

    @NotNull
    private LocalDateTime proximaRetirada;

    @NotNull
    private String local;

    @NotNull
    private String responsavel;

    @NotNull
    private Long prescricaoId;
}
