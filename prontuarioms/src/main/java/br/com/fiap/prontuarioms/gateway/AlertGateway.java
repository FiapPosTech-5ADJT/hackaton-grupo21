package br.com.fiap.prontuarioms.gateway;

import br.com.fiap.prontuarioms.domain.Alerta;

import java.util.List;
import java.util.Optional;

public interface AlertGateway {
    List<Alerta> findByCpf(String cpf);

    Optional<Alerta> findById(Long id);

    Alerta save(Alerta alerta);

    void deleteById(Long id);

}
