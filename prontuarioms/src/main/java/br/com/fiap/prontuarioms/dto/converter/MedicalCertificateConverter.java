package br.com.fiap.prontuarioms.dto.converter;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.dto.MedicalCertificateCreateRequestDto;
import br.com.fiap.prontuarioms.dto.MedicalCertificateUpdateRequestDto;

public class MedicalCertificateConverter {
    
    public static Atestado toDomain(MedicalCertificateCreateRequestDto dto) {
        return new Atestado(dto.cpf(), dto.descricao(), dto.diasAfastamento());
    }

    public static Atestado toDomain(MedicalCertificateUpdateRequestDto dto) {
        return new Atestado(dto.id(), dto.cpf(), dto.descricao(), dto.diasAfastamento());
    }
}
