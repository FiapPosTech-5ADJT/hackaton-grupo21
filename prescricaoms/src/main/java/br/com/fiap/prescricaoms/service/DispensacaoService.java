package br.com.fiap.prescricaoms.service;

import br.com.fiap.prescricaoms.dto.DispensacaoDTO;
import br.com.fiap.prescricaoms.model.Dispensacao;
import br.com.fiap.prescricaoms.repository.DispensacaoRepository;
import br.com.fiap.prescricaoms.repository.PrescricaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DispensacaoService {

    private final DispensacaoRepository dispensacaoRepository;
    private final PrescricaoRepository prescricaoRepository;

    public DispensacaoService(DispensacaoRepository dispensacaoRepository, PrescricaoRepository prescricaoRepository) {
        this.dispensacaoRepository = dispensacaoRepository;
      this.prescricaoRepository = prescricaoRepository;
    }

    public DispensacaoDTO cadastrarDispensacao(DispensacaoDTO dispensacaoDTO) {
      Dispensacao dispensacao = mapToEntity(dispensacaoDTO);

      // Validação: Verificar se a retirada é permitida
      List<Dispensacao> dispensacoes = dispensacaoRepository.findByPrescricaoId(dispensacao.getPrescricao().getId());
      dispensacoes.stream()
        .filter(d -> d.getProximaRetirada() != null && d.getProximaRetirada().isAfter(LocalDateTime.now()))
        .findAny()
        .ifPresent(d -> {
          throw new RuntimeException("Retirada não permitida antes da data: " + d.getProximaRetirada());
        });

      // Definir a data de retirada atual e calcular a próxima
      dispensacao.setDataRetirada(LocalDateTime.now());
      dispensacao.setProximaRetirada(dispensacao.getDataRetirada().plusDays(30)); // Exemplo: 30 dias para próxima retirada

      // Salvar a entidade
      Dispensacao dispensacaoSalva = dispensacaoRepository.save(dispensacao);

      // Mapear a entidade salva para DTO
      return mapToDTO(dispensacaoSalva);
    }

    public List<DispensacaoDTO> consultarDispensacoesPorPrescricao(Long prescricaoId) {
      List<Dispensacao> dispensacoes = dispensacaoRepository.findByPrescricaoId(prescricaoId);
      return dispensacoes.stream()
        .map(this::mapToDTO)
        .toList();
    }
    private Dispensacao mapToEntity(DispensacaoDTO dispensacaoDTO) {
      Dispensacao dispensacao = new Dispensacao();
      dispensacao.setDataRetirada(dispensacaoDTO.getDataRetirada());
      dispensacao.setProximaRetirada(dispensacaoDTO.getProximaRetirada());
      dispensacao.setLocal(dispensacaoDTO.getLocal());
      dispensacao.setResponsavel(dispensacaoDTO.getResponsavel());
      dispensacao.setPrescricao(prescricaoRepository.findById(dispensacaoDTO.getPrescricaoId())
        .orElseThrow(() -> new RuntimeException("Prescrição não encontrada")));
      return dispensacao;
    }
    private DispensacaoDTO mapToDTO(Dispensacao dispensacao) {
      DispensacaoDTO dto = new DispensacaoDTO();
      dto.setDataRetirada(dispensacao.getDataRetirada());
      dto.setProximaRetirada(dispensacao.getProximaRetirada());
      dto.setLocal(dispensacao.getLocal());
      dto.setResponsavel(dispensacao.getResponsavel());
      dto.setPrescricaoId(dispensacao.getPrescricao().getId());
      return dto;
    }
}
