package br.gov.susconnect.exames.application.service;

import br.gov.susconnect.exames.application.dto.AgendamentoExameRequestDTO;
import br.gov.susconnect.exames.application.dto.AgendamentoExameResponseDTO;
import br.gov.susconnect.exames.domain.model.AgendamentoExame;
import br.gov.susconnect.exames.domain.repository.AgendamentoExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoExameService {
    @Autowired
    private SolicitacaoExameService solicitacaoExameService;

    @Autowired
    private UnidadeSaudeService unidadeSaudeService;
    @Autowired
    private AgendamentoExameRepository agendamentoExameRepository;

    public AgendamentoExameResponseDTO agendar(AgendamentoExameRequestDTO dto) {
        AgendamentoExame agendamento = new AgendamentoExame();
        agendamento.setIdSolicitacao(dto.getIdSolicitacao());
        agendamento.setIdUnidadeSaude(dto.getIdUnidadeSaude());
        agendamento.setDataHora(dto.getDataHora());
        agendamento.setStatus("pendente");

        AgendamentoExame saved = agendamentoExameRepository.save(agendamento);
        return convertToResponseDTO(saved);
    }

    public void cancelar(Long id) {
        Optional<AgendamentoExame> agendamento = agendamentoExameRepository.findById(id);
        if (agendamento.isPresent()) {
            AgendamentoExame agendamentoExame = agendamento.get();
            agendamentoExame.setStatus("cancelado");
            agendamentoExameRepository.save(agendamentoExame);
        } else {
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
    }

  private AgendamentoExameResponseDTO convertToResponseDTO(AgendamentoExame agendamento) {
    AgendamentoExameResponseDTO dto = new AgendamentoExameResponseDTO();
    dto.setId(agendamento.getId());
    dto.setSolicitacaoExame(solicitacaoExameService.buscarPorId(agendamento.getIdSolicitacao()));
    dto.setUnidadeSaude(unidadeSaudeService.buscarPorId(agendamento.getIdUnidadeSaude()));
    dto.setDataHora(agendamento.getDataHora());
    dto.setStatus(agendamento.getStatus());
    return dto;
  }
    public List<AgendamentoExameResponseDTO> buscarPorPeriodo(String inicio, String fim) {
      DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
      LocalDateTime dataInicio = LocalDateTime.parse(inicio, formatter);
      LocalDateTime dataFim = LocalDateTime.parse(fim, formatter);

      return agendamentoExameRepository.findByDataHoraBetween(dataInicio, dataFim).stream()
        .map(this::convertToResponseDTO)
        .collect(Collectors.toList());
    }
}
