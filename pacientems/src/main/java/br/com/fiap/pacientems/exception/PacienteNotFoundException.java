package br.com.fiap.pacientems.exception;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String cpf) {
        super("Paciente não encontrado com CPF: " + cpf);
    }
}
