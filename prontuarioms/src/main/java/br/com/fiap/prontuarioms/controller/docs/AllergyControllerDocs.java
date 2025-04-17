package br.com.fiap.prontuarioms.controller.docs;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.dto.AllergyCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AllergyUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Alergias", description = "Gerenciamento de registros de alergias de pacientes")
public interface AllergyControllerDocs {

    @Operation(summary = "Cria um novo registro de alergia",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "cpf": "12345678900",
                      "descricaoAlergia": "Alergia a amendoim",
                      "descricaoConsequencias": "Reações respiratórias graves"
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Alergia registrada com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alergia.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    ResponseEntity<Alergia> createAllergy(@RequestBody AllergyCreateRequestDto allergyCreateRequestDto);

    @Operation(summary = "Atualiza uma alergia existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "cpf": "12345678900",
                      "descricaoAlergia": "Alergia a frutos do mar",
                      "descricaoConsequencias": "Coceira e inchaço"
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Alergia atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Alergia não encontrada")
            }
    )
    @PutMapping
    ResponseEntity<Void> updateAllergy(@RequestBody AllergyUpdateRequestDto allergyUpdateRequestDto);

    @Operation(summary = "Exclui uma alergia pelo ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Alergia excluída com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Alergia não encontrada")
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAllergy(@PathVariable Long id);

    @Operation(summary = "Lista alergias pelo CPF do paciente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alergias",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alergia.class)))
            }
    )
    @GetMapping("/{cpf}")
    ResponseEntity<List<Alergia>> getAllergies(@PathVariable String cpf);
}
