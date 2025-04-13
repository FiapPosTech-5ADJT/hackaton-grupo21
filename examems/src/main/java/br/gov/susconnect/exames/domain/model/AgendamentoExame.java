package br.gov.susconnect.exames.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "agendamento_exame")
public class AgendamentoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_solicitacao", nullable = false)
    private Long idSolicitacao;

    @Column(name = "id_unidade_saude", nullable = false)
    private Long idUnidadeSaude;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String status = "pendente";
}
