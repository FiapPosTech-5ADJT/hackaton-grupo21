package br.gov.susconnect.exames.application.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ResultadoExameRequestDTO {
    private Long idAgendamento;
    private MultipartFile arquivoResultado; // Arquivo enviado
    private String observacoes;
}
