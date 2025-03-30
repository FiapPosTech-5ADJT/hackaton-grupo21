package br.com.fiap.prontuarioms.domain;

import java.time.LocalDateTime;

public class Alerta {
    private Long id;
    private String cpf;
    private String descricao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Alerta(String cpf, Long id, String descricao, LocalDateTime dataCadastro, LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (cpf == null || cpf.isEmpty()){
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (descricao == null || descricao.isEmpty()){
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        if (dataCadastro == null){
            throw new IllegalArgumentException("Data de cadastro não pode ser nula");
        }
        if (dataInicio == null){
            throw new IllegalArgumentException("Data de início não pode ser nula");
        }
        if (dataFim == null){
            throw new IllegalArgumentException("Data de fim não pode ser nula");
        }
        if(dataFim.isBefore(dataInicio)){
            throw new IllegalArgumentException("Data de fim não pode ser anterior a data de início");
        }

        this.cpf = cpf;
        this.id = id;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Alerta(String cpf, String descricao) {
        this.cpf = cpf;
        this.descricao = descricao;
        this.dataInicio = LocalDateTime.now();
        this.dataCadastro = LocalDateTime.now();
    }

    public boolean possuiAlertaAtivo() {
        return LocalDateTime.now().isAfter(dataInicio) && LocalDateTime.now().isBefore(dataFim);
    }

    public void finalizarAlerta() {
        this.dataFim = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
}
