package br.com.fiap.prontuarioms.dto;

import java.time.LocalDateTime;

public record VaccineCreateRequestDto(String cpf, String descricao, String lote, String fabricante, LocalDateTime dataAplicacao) {
}
