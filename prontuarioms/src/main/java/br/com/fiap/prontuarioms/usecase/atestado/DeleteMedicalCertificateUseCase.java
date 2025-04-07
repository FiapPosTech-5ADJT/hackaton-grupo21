package br.com.fiap.prontuarioms.usecase.atestado;

import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteMedicalCertificateUseCase {

    private final MedicalCertificateGateway gateway;

    public void execute(Long id) {
        gateway.deleteById(id);
    }
}
