package br.com.fiap.prontuarioms.usecase.alerta;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.gateway.AlertGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAlertUseCase {

    private final AlertGateway gateway;

    public void execute(Long id) {
        gateway.deleteById(id);
    }
}
