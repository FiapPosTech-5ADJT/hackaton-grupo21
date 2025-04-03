package br.com.fiap.prontuarioms.gateway.database.jpa;

import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.domain.Alergia;
import br.com.fiap.prontuarioms.exception.ErroAoSalvarException;
import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AlergiaEntity;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.AllergyJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class AllergyJpaGateway implements AllergyGateway {

    private final AllergyJpaRepository allergyRepository;

    @Override
    public List<Alergia> findByCpf(String cpf) {
        List<AlergiaEntity> listaEntidade = allergyRepository.findByCpf(cpf);
        if (listaEntidade == null || listaEntidade.isEmpty()) {
            return Collections.emptyList();
        }
        return listaEntidade.stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Alergia> findById(Long id) {
        Optional<AlergiaEntity> alergiaEntity = this.allergyRepository.findById(id);
        if (alergiaEntity.isEmpty()) {
            log.info("Alergia não encontrado id: {}", id);
            return Optional.empty();
        }
        Alergia alerta = toDomain(alergiaEntity.get());
        return Optional.of(alerta);
    }

    @Override
    public Alergia save(Alergia alergia) {
        try {
            AlergiaEntity alergiaEntity = toEntity(alergia);
            alergiaEntity = this.allergyRepository.save(alergiaEntity);
            return toDomain(alergiaEntity);
        } catch (Exception e) {
            log.error("Erro ao salvar alergia: {}", e.getMessage());
            throw new ErroAoSalvarException("Erro ao salvar alergia");
        }
    }

    @Override
    public void deleteById(Long id) {
        this.allergyRepository.deleteById(id);
    }

    private Alergia toDomain(AlergiaEntity alergiaEntity) {
        return new Alergia(
                alergiaEntity.getId(),
                alergiaEntity.getCpf(),
                alergiaEntity.getDescricaoAlergia(),
                alergiaEntity.getDescricaoConsequencias(),
                alergiaEntity.getDataCadastro()
        );
    }

    private AlergiaEntity toEntity(Alergia alerta) {
        return AlergiaEntity.builder()
                .id(alerta.getId())
                .cpf(alerta.getCpf())
                .descricaoAlergia(alerta.getDescricaoAlergia())
                .descricaoConsequencias(alerta.getDescricaoConsequencias())
                .dataCadastro(alerta.getDataCadastro())
                .build();
    }
}
