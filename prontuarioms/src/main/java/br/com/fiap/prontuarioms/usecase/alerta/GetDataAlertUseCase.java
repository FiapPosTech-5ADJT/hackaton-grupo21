package br.com.fiap.prontuarioms.usecase.alerta;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.gateway.AlertGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetDataAlertUseCase {

    private final AlertGateway gateway;

    public List<Alerta> execute(String cpf) {
        return gateway.findByCpf(cpf);
    }
}
