package com.company.exercicio1.dto;

import com.company.exercicio1.modelo.Estado;

public class RegiaoDTO {

    private Long id;
    private String nome;
    private String regiao;
    private String capital;

    public RegiaoDTO(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.regiao = estado.getRegiao();
        this.capital = estado.getCapital();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getCapital() {
        return capital;
    }
}
