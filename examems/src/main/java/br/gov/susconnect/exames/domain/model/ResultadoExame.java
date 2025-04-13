package br.gov.susconnect.exames.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "resultado_exame")
public class ResultadoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_agendamento", nullable = false)
    private Long idAgendamento;

    @Column(name = "arquivo_resultado", nullable = false)
    private String arquivoResultado; // Alterado para String

    @Column(name = "data_liberacao", nullable = false)
    private LocalDateTime dataLiberacao;

    @Column(name = "observacoes")
    private String observacoes;

}
