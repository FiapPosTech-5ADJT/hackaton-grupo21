package br.com.fiap.prontuarioms.gateway;

import br.com.fiap.prontuarioms.domain.Atestado;

import java.util.List;
import java.util.Optional;

public interface MedicalCertificateGateway {
    List<Atestado> findByCpf(String cpf);
    Optional<Atestado> findById(Long id);
    Atestado save(Atestado Atestado);
    void deleteById(Long id);
}
