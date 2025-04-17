package br.com.fiap.prontuarioms.controller.docs;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.dto.MedicalCertificateCreateRequestDto;
import br.com.fiap.prontuarioms.dto.MedicalCertificateUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Atestados", description = "Gerenciamento de registros de atestados médicos")
public interface MedicalCertificateControllerDocs {

    @Operation(summary = "Cria um novo atestado médico",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "cpf": "12345678900",
                      "descricao": "Afastamento por gripe",
                      "diasAfastamento": 3
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Atestado criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Atestado.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    ResponseEntity<Atestado> create(@RequestBody MedicalCertificateCreateRequestDto dto);

    @Operation(summary = "Atualiza um atestado médico existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "cpf": "12345678900",
                      "descricao": "Afastamento por dengue",
                      "diasAfastamento": 5
                    }
                """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Atestado atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Atestado não encontrado")
            }
    )
    @PutMapping
    ResponseEntity<Void> update(@RequestBody MedicalCertificateUpdateRequestDto dto);

    @Operation(summary = "Remove um atestado pelo ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Atestado removido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Atestado não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Lista atestados médicos por CPF do paciente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de atestados",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Atestado.class)))
            }
    )
    @GetMapping("/{cpf}")
    ResponseEntity<List<Atestado>> getAll(@PathVariable String cpf);
}
