package br.gov.susconnect.exames.application.service;

import br.gov.susconnect.exames.application.dto.UnidadeSaudeRequestDTO;
import br.gov.susconnect.exames.application.dto.UnidadeSaudeResponseDTO;
import br.gov.susconnect.exames.domain.model.UnidadeSaude;
import br.gov.susconnect.exames.domain.repository.UnidadeSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnidadeSaudeService {

    @Autowired
    private UnidadeSaudeRepository unidadeSaudeRepository;

    public UnidadeSaudeResponseDTO salvar(UnidadeSaudeRequestDTO dto) {
        UnidadeSaude unidade = convertToEntity(dto);
        return convertToDTO(unidadeSaudeRepository.save(unidade));
    }

    public List<UnidadeSaudeResponseDTO> listarTodos() {
        return unidadeSaudeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UnidadeSaudeResponseDTO buscarPorId(Long id) {
        UnidadeSaude unidade = unidadeSaudeRepository.findById(id).orElse(null);
        return convertToDTO(unidade);
    }

    public List<UnidadeSaudeResponseDTO> buscarPorTipo(String tipo) {
        return unidadeSaudeRepository.findByTipo(tipo).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UnidadeSaudeResponseDTO> buscarPorEstado(String estado) {
        return unidadeSaudeRepository.findByEstado(estado).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UnidadeSaudeResponseDTO> buscarPorCidade(String cidade) {
        return unidadeSaudeRepository.findByCidade(cidade).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        unidadeSaudeRepository.deleteById(id);
    }

    private UnidadeSaude convertToEntity(UnidadeSaudeRequestDTO dto) {
        UnidadeSaude unidade = new UnidadeSaude();
        unidade.setNome(dto.getNome());
        unidade.setEndereco(dto.getEndereco());
        unidade.setTipo(dto.getTipo());
        unidade.setCidade(dto.getCidade());
        unidade.setEstado(dto.getEstado());
        unidade.setLatitude(dto.getLatitude());
        unidade.setLongitude(dto.getLongitude());
        return unidade;
    }

    private UnidadeSaudeResponseDTO convertToDTO(UnidadeSaude unidade) {
        if (unidade == null) return null;
        UnidadeSaudeResponseDTO dto = new UnidadeSaudeResponseDTO();
        dto.setId(unidade.getId());
        dto.setNome(unidade.getNome());
        dto.setEndereco(unidade.getEndereco());
        dto.setTipo(unidade.getTipo());
        dto.setCidade(unidade.getCidade());
        dto.setEstado(unidade.getEstado());
        dto.setLatitude(unidade.getLatitude());
        dto.setLongitude(unidade.getLongitude());
        return dto;
    }
}
