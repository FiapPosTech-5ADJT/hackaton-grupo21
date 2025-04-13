package br.com.fiap.prontuarioms.usecase.alergia;

import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAllergyUseCase {
    private final AllergyGateway allergyGateway;

    public void execute(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo para exclusão");
        }
        allergyGateway.deleteById(id);
    }
}
