package br.com.fiap.prontuarioms.domain;

import java.time.LocalDateTime;

public class Alergia {
    private Long id;
    private String cpf;
    private String descricaoAlergia;
    private String descricaoConsequencias;
    private LocalDateTime dataCadastro;

    public Alergia(Long id, String cpf, String descricaoAlergia, String descricaoConsequencias, LocalDateTime dataCadastro) {
        this.id = id;
        this.cpf = cpf;
        this.descricaoAlergia = descricaoAlergia;
        this.descricaoConsequencias = descricaoConsequencias;
        this.dataCadastro = dataCadastro;
    }

    public Alergia(String cpf, String descricaoAlergia, String descricaoConsequencias) {
        if (cpf == null || cpf.isEmpty()){
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (descricaoAlergia == null || descricaoAlergia.isEmpty()){
            throw new IllegalArgumentException("Descrição da alergia não pode ser nula ou vazia");
        }
        if (descricaoConsequencias == null || descricaoConsequencias.isEmpty()){
            throw new IllegalArgumentException("Descrição das consequências não pode ser nula ou vazia");
        }

        this.cpf = cpf;
        this.descricaoAlergia = descricaoAlergia;
        this.descricaoConsequencias = descricaoConsequencias;
        this.dataCadastro = LocalDateTime.now();
    }
}
