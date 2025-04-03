package br.com.fiap.prontuarioms.gateway;

import br.com.fiap.prontuarioms.domain.Vacina;

import java.util.List;
import java.util.Optional;

public interface VaccineGateway {
    List<Vacina> findByCpf(String cpf);
    Optional<Vacina> findById(Long id);
    Vacina save(Vacina Vacina);
    void deleteById(Long id);
}
