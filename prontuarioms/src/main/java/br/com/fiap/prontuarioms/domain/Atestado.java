package br.com.fiap.prontuarioms.domain;

import java.time.LocalDateTime;

public class Atestado {
    private Long id;
    private String cpf;
    private String descricao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataInicio;
    private Long diasAfastamento;


    public Atestado(Long id, String cpf, String descricao, LocalDateTime dataCadastro, LocalDateTime dataInicio, Long diasAfastamento) {
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
        if (diasAfastamento == null){
            throw new IllegalArgumentException("Dias de afastamento não pode ser nulo");
        }

        this.id = id;
        this.cpf = cpf;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataInicio = dataInicio;
        this.diasAfastamento = diasAfastamento;
    }

    public Atestado(String cpf, String descricao, Long diasAfastamento) {
        this.cpf = cpf;
        this.descricao = descricao;
        if (diasAfastamento == null){
            throw new IllegalArgumentException("Dias de afastamento não pode ser nulo");
        }
        if (diasAfastamento > 30){
            throw new IllegalArgumentException("Dias de afastamento não pode ser maior que 30");
        }
        if (diasAfastamento < 0){
            throw new IllegalArgumentException("Dias de afastamento não pode ser menor que 0");
        }
        this.diasAfastamento = diasAfastamento;
        this.dataInicio = LocalDateTime.now();
        this.dataCadastro = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public Long getDiasAfastamento() {
        return diasAfastamento;
    }

    public void finalizarAfastamento() {
        this.diasAfastamento = 0L;
        this.dataInicio = LocalDateTime.now();
    }

    public boolean possuiAfastamentoAtivo() {
        return this.diasAfastamento > 0 && LocalDateTime.now().isBefore(dataInicio.plusDays(diasAfastamento));
    }
}
