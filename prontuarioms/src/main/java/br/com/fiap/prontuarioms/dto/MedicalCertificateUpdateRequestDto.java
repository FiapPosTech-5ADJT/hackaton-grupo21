package br.com.fiap.prontuarioms.dto;

public record MedicalCertificateUpdateRequestDto(Long id, String cpf, String descricao, Long diasAfastamento) {
}
