package br.com.fiap.prontuarioms.controller.docs;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.dto.VaccineCreateRequestDto;
import br.com.fiap.prontuarioms.dto.VaccineUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vacinas", description = "Gerenciamento de registros de vacinas aplicadas")
public interface VaccineControllerDocs {

    @Operation(summary = "Cria um novo registro de vacina",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "cpf": "12345678900",
                      "descricao": "Vacina contra gripe",
                      "lote": "L123",
                      "fabricante": "Fiocruz",
                      "dataAplicacao": "2024-04-17T09:00:00"
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Vacina registrada com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vacina.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    ResponseEntity<Vacina> create(@RequestBody VaccineCreateRequestDto dto);

    @Operation(summary = "Atualiza um registro de vacina existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "cpf": "12345678900",
                      "descricao": "Vacina contra tétano",
                      "lote": "L456",
                      "fabricante": "Butantan",
                      "dataAplicacao": "2024-03-10T14:30:00"
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Vacina atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Vacina não encontrada")
            }
    )
    @PutMapping
    ResponseEntity<Void> update(@RequestBody VaccineUpdateRequestDto dto);

    @Operation(summary = "Remove um registro de vacina pelo ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Vacina removida com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Vacina não encontrada")
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Lista vacinas aplicadas por CPF do paciente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de vacinas",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vacina.class)))
            }
    )
    @GetMapping("/{cpf}")
    ResponseEntity<List<Vacina>> getAll(@PathVariable String cpf);
}
