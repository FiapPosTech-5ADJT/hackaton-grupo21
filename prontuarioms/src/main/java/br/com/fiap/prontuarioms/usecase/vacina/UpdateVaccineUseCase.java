package br.com.fiap.prontuarioms.usecase.vacina;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateVaccineUseCase {

    private final VaccineGateway gateway;

    public void execute(Vacina vacina) {
        gateway.save(vacina);
    }
}
