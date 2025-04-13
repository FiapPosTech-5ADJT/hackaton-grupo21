package br.com.fiap.prontuarioms.dto;

import java.time.LocalDateTime;

public record VaccineUpdateRequestDto (
        Long id,
        String cpf,
        String descricao,
        String lote,
        String fabricante,
        LocalDateTime dataAplicacao
) {
}
