package br.com.fiap.prescricaoms.repository;

import br.com.fiap.prescricaoms.enums.StatusPrescricao;
import br.com.fiap.prescricaoms.model.Prescricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {
    List<Prescricao> findByCpfPacienteAndStatus(String cpfPaciente, StatusPrescricao status);
    List<Prescricao> findByCpfPaciente(String cpf);
}
