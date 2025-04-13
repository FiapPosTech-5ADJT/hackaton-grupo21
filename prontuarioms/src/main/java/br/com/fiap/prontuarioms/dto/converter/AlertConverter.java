package br.com.fiap.prontuarioms.dto.converter;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.dto.AlertCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AlertUpdateRequestDto;

public class AlertConverter {
    
    public static Alerta toDomain(AlertCreateRequestDto dto) {
        return new Alerta(dto.cpf(), dto.descricao(), dto.dataInicio(), dto.dataFim());
    }

    public static Alerta toDomain(AlertUpdateRequestDto dto) {
        return new Alerta(dto.id(), dto.cpf(), dto.descricao(), dto.dataInicio(), dto.dataFim());
    }
}
