package com.example.ProjetoFinalBackEnd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_tripulacao")
public class TripulacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plataforma;
    private String funcionario;
    private String funcao;
    private String dataInicio; // Pode ser alterado para LocalDate se preferir tratar formatação no front
    private String dataFim;
    private String escala;

    public TripulacaoModel() {
    }

    public TripulacaoModel(Long id, String plataforma, String funcionario, String funcao, String dataInicio, String dataFim, String escala) {
        this.id = id;
        this.plataforma = plataforma;
        this.funcionario = funcionario;
        this.funcao = funcao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.escala = escala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }
}
