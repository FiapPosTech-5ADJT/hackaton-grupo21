package br.gov.susconnect.exames.application.service;

import br.gov.susconnect.exames.application.dto.TipoExameRequestDTO;
import br.gov.susconnect.exames.application.dto.TipoExameResponseDTO;
import br.gov.susconnect.exames.domain.model.TipoExame;
import br.gov.susconnect.exames.domain.repository.TipoExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoExameService {

    @Autowired
    private TipoExameRepository tipoExameRepository;

    public TipoExameResponseDTO salvar(TipoExameRequestDTO tipoExameDTO) {
      return convertToDTO(tipoExameRepository.save(convertToEntity(tipoExameDTO)));
    }

    public List<TipoExame> listarTodos() {
        return tipoExameRepository.findAll();
    }

    public TipoExame buscarPorId(Long id) {
        return tipoExameRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        tipoExameRepository.deleteById(id);
    }

  public TipoExame convertToEntity(TipoExameRequestDTO tipoExameDTO) {
    if (tipoExameDTO == null) {
      return null;
    }

    TipoExame tipoExame = new TipoExame();
    tipoExame.setNome(tipoExameDTO.getNome());
    tipoExame.setDescricao(tipoExameDTO.getDescricao());
    tipoExame.setPreparoNecessario(tipoExameDTO.getPreparoNecessario());
    tipoExame.setPrazoEntrega(tipoExameDTO.getPrazoEntrega());

    return tipoExame;
  }

  public TipoExameResponseDTO convertToDTO(TipoExame tipoExame) {
    if (tipoExame == null) {
      return null;
    }

    TipoExameResponseDTO tipoExameDTO = new TipoExameResponseDTO();
    tipoExameDTO.setId(tipoExame.getId());
    tipoExameDTO.setNome(tipoExame.getNome());
    tipoExameDTO.setDescricao(tipoExame.getDescricao());
    tipoExameDTO.setPreparoNecessario(tipoExame.getPreparoNecessario());
    tipoExameDTO.setPrazoEntrega(tipoExame.getPrazoEntrega());

    return tipoExameDTO;
  }

}
