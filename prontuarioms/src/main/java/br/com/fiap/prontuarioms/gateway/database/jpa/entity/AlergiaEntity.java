package br.com.fiap.prontuarioms.gateway.database.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Alergia")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlergiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String descricaoAlergia;
    private String descricaoConsequencias;
    private LocalDateTime dataCadastro;
}