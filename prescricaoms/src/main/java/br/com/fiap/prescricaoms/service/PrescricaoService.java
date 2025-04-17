package br.com.fiap.prescricaoms.service;

import br.com.fiap.prescricaoms.dto.ItemPrescricaoDTO;
import br.com.fiap.prescricaoms.dto.PrescricaoDTO;
import br.com.fiap.prescricaoms.enums.StatusPrescricao;
import br.com.fiap.prescricaoms.model.ItemPrescricao;
import br.com.fiap.prescricaoms.model.Prescricao;
import br.com.fiap.prescricaoms.repository.PrescricaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescricaoService {

  private final PrescricaoRepository prescricaoRepository;

  public PrescricaoService(PrescricaoRepository prescricaoRepository) {
    this.prescricaoRepository = prescricaoRepository;
  }
  @Transactional
  public PrescricaoDTO cadastrarPrescricao(PrescricaoDTO prescricaoDto) {
    Prescricao prescricao = this.mapToEntity(prescricaoDto);
    Prescricao prescricaoSalva = prescricaoRepository.save(prescricao);
    return this.mapToDTO(prescricaoSalva);
  }

  public List<PrescricaoDTO> consultarPrescricoesAtivas(String cpfPaciente) {
    List<Prescricao> prescricoes = prescricaoRepository.findByCpfPacienteAndStatus(cpfPaciente, StatusPrescricao.ATIVA);
    return prescricoes.stream().map(this::mapToDTO).collect(Collectors.toList());
  }
  public Prescricao atualizarPrescricao(Long id, Prescricao prescricaoAtualizada) {
    return prescricaoRepository.findById(id).map(prescricao -> {
      prescricao.setCpfPaciente(prescricaoAtualizada.getCpfPaciente());
      prescricao.setCpfProfissional(prescricaoAtualizada.getCpfProfissional());
      prescricao.setData(prescricaoAtualizada.getData());
      prescricao.setStatus(prescricaoAtualizada.getStatus());
      prescricao.setItens(prescricaoAtualizada.getItens());
      return prescricaoRepository.save(prescricao);
    }).orElseThrow(() -> new RuntimeException("Prescrição não encontrada"));
  }

  public List<PrescricaoDTO> consultarHistoricoPrescricoes(String cpf) {
    List<Prescricao> prescricoes = prescricaoRepository.findByCpfPaciente(cpf);
    return prescricoes.stream().map(this::mapToDTO).collect(Collectors.toList());
  }

  public Prescricao mapToEntity(PrescricaoDTO prescricaoDTO) {
    Prescricao prescricao = new Prescricao();
    prescricao.setCpfPaciente(prescricaoDTO.getCpfPaciente());
    prescricao.setCpfProfissional(prescricaoDTO.getCpfProfissional());
    prescricao.setData(prescricaoDTO.getData());
    if (prescricaoDTO.getItens() != null) {
      List<ItemPrescricao> itens = prescricaoDTO.getItens().stream().map(itemDTO -> {
        ItemPrescricao item = mapItemToEntity(itemDTO);
        item.setPrescricao(prescricao); // Configura a associação bidirecional
        return item;
      }).collect(Collectors.toList());
      prescricao.setItens(itens);
    }
    return prescricao;
  }

  public PrescricaoDTO mapToDTO(Prescricao prescricao) {
    PrescricaoDTO prescricaoDTO = new PrescricaoDTO();
    prescricaoDTO.setCpfPaciente(prescricao.getCpfPaciente());
    prescricaoDTO.setCpfProfissional(prescricao.getCpfProfissional());
    prescricaoDTO.setData(prescricao.getData());
    if (prescricao.getItens() != null) {
      List<ItemPrescricaoDTO> itens = prescricao.getItens().stream().map(this::mapItemToDTO).collect(Collectors.toList());
      prescricaoDTO.setItens(itens);
    }
    return prescricaoDTO;
  }

  private ItemPrescricao mapItemToEntity(ItemPrescricaoDTO itemDTO) {
    ItemPrescricao item = new ItemPrescricao();
    item.setMedicamento(itemDTO.getMedicamento());
    item.setDosagem(itemDTO.getDosagem());
    item.setIntervaloHoras(itemDTO.getIntervaloHoras());
    item.setRecorrente(itemDTO.getRecorrente());
    return item;
  }

  private ItemPrescricaoDTO mapItemToDTO(ItemPrescricao item) {
    ItemPrescricaoDTO itemDTO = new ItemPrescricaoDTO();
    itemDTO.setMedicamento(item.getMedicamento());
    itemDTO.setDosagem(item.getDosagem());
    itemDTO.setIntervaloHoras(item.getIntervaloHoras());
    itemDTO.setRecorrente(item.getRecorrente());
    return itemDTO;
  }

}
