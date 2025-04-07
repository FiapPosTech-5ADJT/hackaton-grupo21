package br.com.fiap.prontuarioms.usecase.alerta;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.gateway.AlertGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateAlertUseCase {

    private final AlertGateway gateway;

    public void execute(Alerta alerta) {
        gateway.save(alerta);
    }
}
