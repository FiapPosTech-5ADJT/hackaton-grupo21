package br.gov.susconnect.exames.application.service;
import br.gov.susconnect.exames.application.dto.ResultadoExameRequestDTO;
import br.gov.susconnect.exames.domain.model.ResultadoExame;
import br.gov.susconnect.exames.domain.repository.ResultadoExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResultadoExameService {

    private static final String UPLOAD_DIR = "uploads/resultados"; // Diretório local para salvar os arquivos

    @Autowired
    private ResultadoExameRepository resultadoExameRepository;

    public ResultadoExame salvarResultado(ResultadoExameRequestDTO dto) {
      try {
        // Gerar uma chave aleatória para o arquivo
        String randomKey = "s3-" + System.currentTimeMillis() + "-" + dto.getArquivoResultado().getOriginalFilename();

        // Simular o upload para o S3
        System.out.println("Simulando upload para o S3 com a chave: " + randomKey);

        // Criar a entidade ResultadoExame
        ResultadoExame resultado = new ResultadoExame();
        resultado.setIdAgendamento(dto.getIdAgendamento());
        resultado.setObservacoes(dto.getObservacoes());
        resultado.setDataLiberacao(LocalDateTime.now());
        resultado.setArquivoResultado(randomKey); // Armazena a chave como referência

        // Salvar no repositório
        return resultadoExameRepository.save(resultado);
      } catch (Exception e) {
        throw new RuntimeException("Erro ao processar o resultado", e);
      }
    }
}
