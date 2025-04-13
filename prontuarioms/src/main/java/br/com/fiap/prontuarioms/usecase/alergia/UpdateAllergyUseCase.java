package br.com.fiap.prontuarioms.usecase.alergia;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateAllergyUseCase {
    private final AllergyGateway allergyGateway;

    public Alergia execute(Alergia alergia) {
        if (alergia.getId() == null) {
            throw new IllegalArgumentException("ID não pode ser nulo para atualização");
        }
        return allergyGateway.save(alergia);
    }
}
