package br.com.fiap.prontuarioms.usecase.alergia;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetDataAllergyUseCase {

    private final AllergyGateway allergyGateway;

    public List<Alergia> execute(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        return allergyGateway.findByCpf(cpf);
    }
}
