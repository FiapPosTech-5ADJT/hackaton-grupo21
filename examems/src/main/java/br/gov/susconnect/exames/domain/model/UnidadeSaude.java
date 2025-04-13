package br.gov.susconnect.exames.domain.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "unidade_saude")
public class UnidadeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    @Column(length = 50)
    private String tipo;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    private Double latitude;
    private Double longitude;
}
