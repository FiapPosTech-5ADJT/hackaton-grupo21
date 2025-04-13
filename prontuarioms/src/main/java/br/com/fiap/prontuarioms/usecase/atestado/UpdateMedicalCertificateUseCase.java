package br.com.fiap.prontuarioms.usecase.atestado;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateMedicalCertificateUseCase {

    private final MedicalCertificateGateway gateway;

    public void execute(Atestado atestado) {
        gateway.save(atestado);
    }
}
