package br.com.fiap.prontuarioms.usecase.vacina;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetDataVaccineUseCase {

    private final VaccineGateway gateway;

    public List<Vacina> execute(String cpf) {
        return gateway.findByCpf(cpf);
    }

}
