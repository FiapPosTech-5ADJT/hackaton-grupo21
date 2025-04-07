package br.com.fiap.prontuarioms.dto.converter;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.dto.AllergyCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AllergyUpdateRequestDto;

import java.time.LocalDateTime;

public class AllergyConverter {

    public static Alergia toDomain(AllergyCreateRequestDto allergyCreateRequestDto) {
        return new Alergia(
                allergyCreateRequestDto.cpf(),
                allergyCreateRequestDto.descricaoAlergia(),
                allergyCreateRequestDto.descricaoConsequencias()
        );
    }

    public static Alergia toDomain(AllergyUpdateRequestDto allergyUpdateRequestDto) {
        return new Alergia(
                allergyUpdateRequestDto.id(),
                allergyUpdateRequestDto.cpf(),
                allergyUpdateRequestDto.descricaoAlergia(),
                allergyUpdateRequestDto.descricaoConsequencias(),
                LocalDateTime.now()
        );
    }
}
