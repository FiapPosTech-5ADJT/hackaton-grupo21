package br.com.fiap.prontuarioms.usecase.alerta;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.gateway.AlertGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlertUseCase {

    private final AlertGateway gateway;

    public Alerta execute(Alerta alerta) {
        return gateway.save(alerta);
    }
}
