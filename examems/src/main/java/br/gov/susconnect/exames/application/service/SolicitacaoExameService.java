package br.gov.susconnect.exames.application.service;

import br.gov.susconnect.exames.application.dto.SolicitacaoExameDTO;
import br.gov.susconnect.exames.application.dto.SolicitacaoExameResponseDTO;
import br.gov.susconnect.exames.application.dto.TipoExameResponseDTO;
import br.gov.susconnect.exames.domain.model.SolicitacaoExame;
import br.gov.susconnect.exames.domain.model.TipoExame;
import br.gov.susconnect.exames.domain.repository.SolicitacaoExameRepository;
import br.gov.susconnect.exames.domain.repository.TipoExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoExameService {

    @Autowired
    private SolicitacaoExameRepository solicitacaoExameRepository;

    @Autowired
    private TipoExameRepository tipoExameRepository;

    public SolicitacaoExameDTO salvar(SolicitacaoExameDTO dto) {
        TipoExame tipoExame = tipoExameRepository.findById(dto.getIdTipoExame())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de exame não encontrado"));

        SolicitacaoExame solicitacao = new SolicitacaoExame();
        solicitacao.setIdPaciente(dto.getIdPaciente());
        solicitacao.setIdProfissional(dto.getIdProfissional());
        solicitacao.setTipoExame(tipoExame);
        solicitacao.setUrgente(dto.isUrgente());

        SolicitacaoExame saved = solicitacaoExameRepository.save(solicitacao);
        return convertToDTO(saved);
    }

    public List<SolicitacaoExameResponseDTO> listarTodos() {
      return solicitacaoExameRepository.findAll().stream()
        .map(this::convertToResponseDTO)
        .collect(Collectors.toList());
    }

    private SolicitacaoExameDTO convertToDTO(SolicitacaoExame solicitacao) {
        SolicitacaoExameDTO dto = new SolicitacaoExameDTO();
        dto.setIdPaciente(solicitacao.getIdPaciente());
        dto.setIdProfissional(solicitacao.getIdProfissional());
        dto.setIdTipoExame(solicitacao.getTipoExame().getId());
        dto.setDataSolicitacao(solicitacao.getDataSolicitacao());
        dto.setUrgente(solicitacao.isUrgente());
        return dto;
    }

    private SolicitacaoExameResponseDTO convertToResponseDTO(SolicitacaoExame solicitacao) {
      TipoExameResponseDTO tipoExameDTO = TipoExameResponseDTO.builder()
        .id(solicitacao.getTipoExame().getId())
        .nome(solicitacao.getTipoExame().getNome())
        .descricao(solicitacao.getTipoExame().getDescricao())
        .preparoNecessario(solicitacao.getTipoExame().getPreparoNecessario())
        .prazoEntrega(solicitacao.getTipoExame().getPrazoEntrega())
        .build();

      return SolicitacaoExameResponseDTO.builder()
        .id(solicitacao.getId())
        .idPaciente(solicitacao.getIdPaciente())
        .idProfissional(solicitacao.getIdProfissional())
        .dataSolicitacao(solicitacao.getDataSolicitacao())
        .urgente(solicitacao.isUrgente())
        .tipoExame(tipoExameDTO)
        .build();
    }

    public List<SolicitacaoExameResponseDTO> buscarPorCpfPaciente(String cpf) {
      return solicitacaoExameRepository.findByIdPaciente(cpf).stream()
        .map(this::convertToResponseDTO)
        .collect(Collectors.toList());
    }

  public SolicitacaoExameResponseDTO buscarPorId(Long idSolicitacao) {
    SolicitacaoExame solicitacao = solicitacaoExameRepository.findById(idSolicitacao)
        .orElseThrow(() -> new IllegalArgumentException("Solicitação de exame não encontrada"));

    return convertToResponseDTO(solicitacao);
  }
}
