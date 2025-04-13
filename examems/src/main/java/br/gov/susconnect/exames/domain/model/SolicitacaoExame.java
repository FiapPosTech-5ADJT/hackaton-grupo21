package br.gov.susconnect.exames.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao_exame")
public class SolicitacaoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_paciente", nullable = false, length = 11)
    private String idPaciente;

    @Column(name = "id_profissional", nullable = false, length = 11)
    private String idProfissional;

    @ManyToOne
    @JoinColumn(name = "id_tipo_exame", nullable = false)
    private TipoExame tipoExame;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao = LocalDateTime.now();

    @Column(name = "urgente", nullable = false)
    private boolean urgente = false;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(String idProfissional) {
        this.idProfissional = idProfissional;
    }

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }
}
