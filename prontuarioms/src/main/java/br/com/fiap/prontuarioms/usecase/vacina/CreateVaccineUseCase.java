package br.com.fiap.prontuarioms.usecase.vacina;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateVaccineUseCase {

    private final VaccineGateway gateway;

    public Vacina execute(Vacina vacina) {
       return gateway.save(vacina);
    }
}
