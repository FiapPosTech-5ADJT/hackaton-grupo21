package br.com.fiap.prontuarioms.usecase.alergia;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAllergyUseCase {

    private final AllergyGateway allergyGateway;

    public Alergia execute(Alergia alergia) {
        return allergyGateway.save(alergia);
    }
}
