package br.com.fiap.prontuarioms.dto;

import java.time.LocalDateTime;

public record AlertUpdateRequestDto(Long id, String cpf, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim) {
}
