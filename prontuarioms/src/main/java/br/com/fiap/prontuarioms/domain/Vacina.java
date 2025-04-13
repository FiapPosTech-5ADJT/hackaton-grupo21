package br.com.fiap.prontuarioms.domain;

import java.time.LocalDateTime;

public class Vacina {

    private Long id;
    private String cpf;
    private String descricao;
    private String lote;
    private String fabricante;
    private LocalDateTime dataAplicacao;

    public Vacina(Long id, String cpf, String descricao, String lote, String fabricante, LocalDateTime dataAplicacao) {
        setCpf(cpf);
        setDescricao(descricao);
        setLote(lote);
        setFabricante(fabricante);
        setDataAplicacao(dataAplicacao);
        this.id = id;
    }

    public Vacina(String cpf, String descricao, String lote, String fabricante, LocalDateTime dataAplicacao) {
        setCpf(cpf);
        setDescricao(descricao);
        setLote(lote);
        setFabricante(fabricante);
        setDataAplicacao(dataAplicacao);
    }

    public Vacina(String cpf, String descricao) {
        setCpf(cpf);
        setDescricao(descricao);
    }

    private void setCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        this.cpf = cpf;
    }

    private void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        this.descricao = descricao;
    }

    private void setLote(String lote) {
        if (lote == null || lote.isEmpty()) {
            throw new IllegalArgumentException("Lote não pode ser nulo ou vazio");
        }
        this.lote = lote;
    }

    private void setFabricante(String fabricante) {
        if (fabricante == null || fabricante.isEmpty()) {
            throw new IllegalArgumentException("Fabricante não pode ser nulo ou vazio");
        }
        this.fabricante = fabricante;
    }

    private void setDataAplicacao(LocalDateTime dataAplicacao) {
        if (dataAplicacao == null) {
            throw new IllegalArgumentException("Data de aplicação não pode ser nula ou vazia");
        }
        this.dataAplicacao = dataAplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLote() {
        return lote;
    }

    public String getFabricante() {
        return fabricante;
    }

    public LocalDateTime getDataAplicacao() {
        return dataAplicacao;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }
}