package br.com.fiap.prontuarioms.gateway.database.jpa;

import br.com.fiap.prontuarioms.domain.Vacina;
import br.com.fiap.prontuarioms.exception.ErroAoSalvarException;
import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.entity.VacinaEntity;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.VaccineJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
public class VaccineJpaGateway implements VaccineGateway {

    private final VaccineJpaRepository vaccineRepository;

    @Override
    public List<Vacina> findByCpf(String cpf) {
        List<VacinaEntity> listaEntidade = vaccineRepository.findByCpf(cpf);
        return listaEntidade.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vacina> findById(Long id) {
        return vaccineRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Vacina save(Vacina vacina) {
        try {
            VacinaEntity vacinaEntity = toEntity(vacina);
            vacinaEntity = vaccineRepository.save(vacinaEntity);
            return toDomain(vacinaEntity);
        } catch (Exception e) {
            log.error("Erro ao salvar vacina: {}", e.getMessage());
            throw new ErroAoSalvarException("Erro ao salvar vacina");
        }
    }

    @Override
    public void deleteById(Long id) {
        vaccineRepository.deleteById(id);
    }

    private Vacina toDomain(VacinaEntity vacinaEntity) {
        return new Vacina(
                vacinaEntity.getId(),
                vacinaEntity.getCpf(),
                vacinaEntity.getDescricao(),
                vacinaEntity.getLote(),
                vacinaEntity.getFabricante(),
                vacinaEntity.getDataAplicacao()
        );
    }

    private VacinaEntity toEntity(Vacina vacina) {
        return VacinaEntity.builder()
                .id(vacina.getId())
                .cpf(vacina.getCpf())
                .dataAplicacao(vacina.getDataAplicacao())
                .descricao(vacina.getDescricao())
                .lote(vacina.getLote())
                .fabricante(vacina.getFabricante())
                .build();
    }
}
