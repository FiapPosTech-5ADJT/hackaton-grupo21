package br.com.fiap.prontuarioms.usecase.atestado;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateMedicalCertificateUseCase {

    private final MedicalCertificateGateway gateway;

    public Atestado execute(Atestado atestado) {
        return gateway.save(atestado);
    }
}
