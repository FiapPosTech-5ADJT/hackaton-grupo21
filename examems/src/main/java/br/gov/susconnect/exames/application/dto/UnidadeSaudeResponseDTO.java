package br.gov.susconnect.exames.application.dto;

import lombok.Data;

@Data
public class UnidadeSaudeResponseDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String tipo;
    private String cidade;
    private String estado;
    private Double latitude;
    private Double longitude;
}
