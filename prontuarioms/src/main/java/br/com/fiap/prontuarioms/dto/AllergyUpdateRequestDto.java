package br.com.fiap.prontuarioms.dto;

public record AllergyUpdateRequestDto(Long id, String cpf, String descricaoAlergia, String descricaoConsequencias) {
}
