package br.com.fiap.prontuarioms.gateway.database.jpa;

import br.com.fiap.prontuarioms.domain.Atestado;
import br.com.fiap.prontuarioms.exception.ErroAoSalvarException;
import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.entity.AtestadoEntity;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.MedicalCertificateJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
public class MedicalCertificateJpaGateway implements MedicalCertificateGateway {

    private final MedicalCertificateJpaRepository medicalCertificateRepository;

    @Override
    public List<Atestado> findByCpf(String cpf) {
        List<AtestadoEntity> listaEntidade = medicalCertificateRepository.findByCpf(cpf);
        return listaEntidade.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Atestado> findById(Long id) {
        return medicalCertificateRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Atestado save(Atestado atestado) {
        try {
            AtestadoEntity atestadoEntity = toEntity(atestado);
            atestadoEntity = medicalCertificateRepository.save(atestadoEntity);
            return toDomain(atestadoEntity);
        } catch (Exception e) {
            log.error("Erro ao salvar atestado: {}", e.getMessage());
            throw new ErroAoSalvarException("Erro ao salvar atestado");
        }
    }

    @Override
    public void deleteById(Long id) {
        medicalCertificateRepository.deleteById(id);
    }

    private Atestado toDomain(AtestadoEntity atestadoEntity) {
        return new Atestado(
                atestadoEntity.getId(),
                atestadoEntity.getCpf(),
                atestadoEntity.getDescricao(),
                atestadoEntity.getDataCadastro(),
                atestadoEntity.getDataInicio(),
                atestadoEntity.getDiasAfastamento()
                );
    }

    private AtestadoEntity toEntity(Atestado atestado) {
        return AtestadoEntity.builder()
                .id(atestado.getId())
                .cpf(atestado.getCpf())
                .descricao(atestado.getDescricao())
                .dataCadastro(atestado.getDataCadastro())
                .dataInicio(atestado.getDataInicio())
                .diasAfastamento(atestado.getDiasAfastamento())
                .build();
    }
}
