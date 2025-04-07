package br.com.fiap.prontuarioms.dto.converter;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.dto.VaccineCreateRequestDto;

public class VaccineConverter {
    
    public static Vacina toDomain(VaccineCreateRequestDto dto) {
        return new Vacina(dto.cpf(), dto.descricao(), dto.lote(), dto.fabricante(), dto.dataAplicacao());
    }
}
