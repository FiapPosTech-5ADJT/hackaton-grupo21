package br.com.fiap.prontuarioms.usecase.atestado;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetDataMedicalCertificateUseCase {

    private final MedicalCertificateGateway gateway;

    public List<Atestado> execute(String cpf) {
        return gateway.findByCpf(cpf);
    }
}
