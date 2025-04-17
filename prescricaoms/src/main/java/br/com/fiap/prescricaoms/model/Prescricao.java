package br.com.fiap.prescricaoms.model;

import br.com.fiap.prescricaoms.enums.StatusPrescricao;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cpfPaciente;

    @NotBlank
    private String cpfProfissional;

    @NotNull
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusPrescricao status;

    @OneToMany(mappedBy = "prescricao", cascade = CascadeType.ALL)
    private List<ItemPrescricao> itens;

    @PrePersist
    private void prePersist() {
      if (this.status == null) {
        this.status = StatusPrescricao.ATIVA; // Valor padrão
      }
    }
}
