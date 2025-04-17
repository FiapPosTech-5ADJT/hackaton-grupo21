package br.com.fiap.prontuarioms.controller.docs;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.dto.AlertCreateRequestDto;
import br.com.fiap.prontuarioms.dto.AlertUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Alertas", description = "Operações relacionadas a alertas médicos")
public interface AlertControllerDocs {

    @Operation(summary = "Cria um novo alerta",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                        {
                                          "cpf": "12345678900",
                                          "descricao": "Paciente com alergia grave a penicilina",
                                          "dataInicio": "2025-04-17T09:00:00",
                                          "dataFim": "2025-04-20T18:00:00"
                                        }
                                    """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Alerta criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alerta.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    ResponseEntity<Alerta> createAlert(@RequestBody AlertCreateRequestDto dto);

    @Operation(summary = "Atualiza um alerta existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                        {
                                          "id": 1,
                                          "cpf": "12345678900",
                                          "descricao": "Paciente com alergia a ibuprofeno",
                                          "dataInicio": "2025-04-18T10:00:00",
                                          "dataFim": "2025-04-22T20:00:00"
                                        }
                                    """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Alerta atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Alerta não encontrado")
            }
    )
    @PutMapping
    ResponseEntity<Void> updateAlert(@RequestBody AlertUpdateRequestDto dto);

    @Operation(summary = "Exclui um alerta por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Alerta excluído com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Alerta não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAlert(@PathVariable Long id);

    @Operation(summary = "Lista alertas pelo CPF do paciente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alertas",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alerta.class)))
            }
    )
    @GetMapping("/{cpf}")
    ResponseEntity<List<Alerta>> getAlerts(@PathVariable String cpf);
}
