package com.company.exercicio1.form;

import com.company.exercicio1.modelo.Estado;
import com.company.exercicio1.validation.RegiaoValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotBlank
    private String nome;
    @RegiaoValidator
    private String regiao;
    @NotNull
    private Long populacao;
    @NotBlank
    private String capital;
    @NotNull
    private Double area;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Estado converter() {
        return new Estado(nome, regiao, populacao, capital, area);
    }
}
