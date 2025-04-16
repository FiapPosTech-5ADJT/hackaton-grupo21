package br.com.fiap.pacientems.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void handlePacienteNotFoundException_ShouldReturnNotFoundStatus() {
        String cpf = "12345678900";
        PacienteNotFoundException exception = new PacienteNotFoundException(cpf);

        var response = exceptionHandler.handlePacienteNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Paciente não encontrado com CPF: " + cpf, response.getBody().getMessage());
        assertTrue(response.getBody().getTimestamp() > 0);
    }
}
