package br.com.fiap.prescricaoms.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Dispensacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataRetirada;
    @NotNull
    private LocalDateTime proximaRetirada;
    @NotNull
    private String local;

    @NotNull
    private String responsavel;

    @ManyToOne
    @JoinColumn(name = "prescricao_id")
    private Prescricao prescricao;
}
