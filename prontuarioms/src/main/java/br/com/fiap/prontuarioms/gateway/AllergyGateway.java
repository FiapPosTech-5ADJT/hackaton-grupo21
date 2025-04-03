package br.com.fiap.prontuarioms.gateway;

import br.com.fiap.prontuarioms.domain.Alergia;

import java.util.List;
import java.util.Optional;

public interface AllergyGateway {
    List<Alergia> findByCpf(String cpf);
    Optional<Alergia> findById(Long id);
    Alergia save(Alergia Alergia);
    void deleteById(Long id);
}
