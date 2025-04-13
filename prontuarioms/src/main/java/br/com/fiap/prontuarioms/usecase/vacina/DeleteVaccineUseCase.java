package br.com.fiap.prontuarioms.usecase.vacina;

import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteVaccineUseCase {

    private final VaccineGateway gateway;

    public void execute(Long id) {
        gateway.deleteById(id);
    }
}
