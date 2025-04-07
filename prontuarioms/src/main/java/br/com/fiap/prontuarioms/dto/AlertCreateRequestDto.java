package br.com.fiap.prontuarioms.dto;

import java.time.LocalDateTime;

public record AlertCreateRequestDto(String cpf, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim) {
}
