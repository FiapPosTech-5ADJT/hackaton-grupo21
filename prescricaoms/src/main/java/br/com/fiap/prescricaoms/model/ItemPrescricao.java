package br.com.fiap.prescricaoms.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class ItemPrescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String medicamento;

    @NotNull
    private Double dosagem;

    @NotNull
    private Integer intervaloHoras;

    private Boolean recorrente;

    @ManyToOne
    @JoinColumn(name = "prescricao_id")
    private Prescricao prescricao;
}
