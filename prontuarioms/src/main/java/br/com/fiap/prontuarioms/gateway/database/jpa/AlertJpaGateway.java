package br.com.fiap.prontuarioms.gateway.database.jpa;

import br.com.fiap.prontuarioms.domain.Alerta;
import br.com.fiap.prontuarioms.exception.ErroAoSalvarException;
import br.com.fiap.prontuarioms.gateway.AlertGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AlertaEntity;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.AlertJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class AlertJpaGateway implements AlertGateway {

    private final AlertJpaRepository alertRepository;

    @Override
    public List<Alerta> findByCpf(String cpf) {
        List<AlertaEntity> listaEntidade = alertRepository.findByCpf(cpf);
        if (listaEntidade == null || listaEntidade.isEmpty()) {
            return Collections.emptyList();
        }
        return listaEntidade.stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Alerta> findById(Long id) {
        Optional<AlertaEntity> alertaEntity = this.alertRepository.findById(id);
        if (alertaEntity.isEmpty()) {
            log.info("Alerta não encontrado id: {}", id);
            return Optional.empty();
        }
        Alerta alerta = toDomain(alertaEntity.get());
        return Optional.of(alerta);
    }

    @Override
    public Alerta save(Alerta alerta) {
        try {
            AlertaEntity alertaEntity = toEntity(alerta);
            alertaEntity = this.alertRepository.save(alertaEntity);
            return toDomain(alertaEntity);
        } catch (Exception e) {
            log.error("Erro ao salvar alerta: {}", e.getMessage());
            throw new ErroAoSalvarException("Erro ao salvar alerta");
        }
    }

    @Override
    public void deleteById(Long id) {
        this.alertRepository.deleteById(id);
    }

    private Alerta toDomain(AlertaEntity alertaEntity) {
        return new Alerta(
                alertaEntity.getId(),
                alertaEntity.getCpf(),
                alertaEntity.getDescricao(),
                alertaEntity.getDataCadastro(),
                alertaEntity.getDataInicio(),
                alertaEntity.getDataFim()
        );
    }

    private AlertaEntity toEntity(Alerta alerta) {
        return AlertaEntity.builder()
                .id(alerta.getId())
                .cpf(alerta.getCpf())
                .descricao(alerta.getDescricao())
                .dataCadastro(alerta.getDataCadastro())
                .dataInicio(alerta.getDataInicio())
                .dataFim(alerta.getDataFim())
                .build();
    }
}
