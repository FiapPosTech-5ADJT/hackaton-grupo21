package br.com.fiap.pacientems.controller;

import br.com.fiap.pacientems.domain.Paciente;
import br.com.fiap.pacientems.dto.PacienteCreateRequestDto;
import br.com.fiap.pacientems.dto.PacientePatchRequestDto;
import br.com.fiap.pacientems.exception.PacienteNotFoundException;
import br.com.fiap.pacientems.usecase.paciente.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteControllerTest {

    @Mock
    private CreatePacienteUseCase createPacienteUseCase;

    @Mock
    private PatchPacienteUseCase patchPacienteUseCase;

    @Mock
    private DeletePacienteUseCase deletePacienteUseCase;

    @Mock
    private GetDataPacienteUseCase getDataPacienteUseCase;

    @InjectMocks
    private PacienteController pacienteController;

    private Paciente paciente;
    private PacienteCreateRequestDto createDto;
    private PacientePatchRequestDto patchDto;
    private final String CPF = "12345678900";

    @BeforeEach
    void setUp() {
        paciente = new Paciente();
        paciente.setCpf(CPF);
        paciente.setNome("Test Patient");

        createDto = new PacienteCreateRequestDto();
        createDto.setCpf(CPF);
        createDto.setNome("Test Patient");

        patchDto = new PacientePatchRequestDto();
        patchDto.setNome("Updated Name");
    }

    @Test
    void create_ShouldReturnCreatedPaciente() {
        when(createPacienteUseCase.execute(any(Paciente.class))).thenReturn(paciente);

        var response = pacienteController.create(createDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(paciente, response.getBody());
        verify(createPacienteUseCase).execute(any(Paciente.class));
    }

    @Test
    void getAll_ShouldReturnListOfPacientes() {
        var pacientes = Arrays.asList(paciente);
        when(getDataPacienteUseCase.execute()).thenReturn(pacientes);

        var response = pacienteController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pacientes, response.getBody());
        verify(getDataPacienteUseCase).execute();
    }

    @Test
    void getByCpf_WhenPacienteExists_ShouldReturnPaciente() {
        when(getDataPacienteUseCase.execute(CPF)).thenReturn(Optional.of(paciente));

        var response = pacienteController.getByCpf(CPF);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(paciente, response.getBody());
        verify(getDataPacienteUseCase).execute(CPF);
    }

    @Test
    void getByCpf_WhenPacienteNotFound_ShouldThrowException() {
        when(getDataPacienteUseCase.execute(CPF)).thenReturn(Optional.empty());

        assertThrows(PacienteNotFoundException.class, () -> 
            pacienteController.getByCpf(CPF)
        );
        verify(getDataPacienteUseCase).execute(CPF);
    }

    @Test
    void patch_WhenPacienteExists_ShouldReturnUpdatedPaciente() {
        when(patchPacienteUseCase.execute(eq(CPF), any(PacientePatchRequestDto.class)))
            .thenReturn(paciente);

        var response = pacienteController.patch(CPF, patchDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(paciente, response.getBody());
        verify(patchPacienteUseCase).execute(eq(CPF), any(PacientePatchRequestDto.class));
    }

    @Test
    void patch_WhenPacienteNotFound_ShouldThrowException() {
        when(patchPacienteUseCase.execute(eq(CPF), any(PacientePatchRequestDto.class)))
            .thenThrow(new RuntimeException());

        assertThrows(PacienteNotFoundException.class, () ->
            pacienteController.patch(CPF, patchDto)
        );
        verify(patchPacienteUseCase).execute(eq(CPF), any(PacientePatchRequestDto.class));
    }

    @Test
    void delete_WhenPacienteExists_ShouldReturnNoContent() {
        doNothing().when(deletePacienteUseCase).execute(CPF);

        var response = pacienteController.delete(CPF);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(deletePacienteUseCase).execute(CPF);
    }

    @Test
    void delete_WhenPacienteNotFound_ShouldThrowException() {
        doThrow(new RuntimeException()).when(deletePacienteUseCase).execute(CPF);

        assertThrows(PacienteNotFoundException.class, () ->
            pacienteController.delete(CPF)
        );
        verify(deletePacienteUseCase).execute(CPF);
    }
}
