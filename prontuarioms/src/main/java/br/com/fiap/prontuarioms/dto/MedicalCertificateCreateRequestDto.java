package br.com.fiap.prontuarioms.dto;

public record MedicalCertificateCreateRequestDto(String cpf, String descricao, Long diasAfastamento) {
}
