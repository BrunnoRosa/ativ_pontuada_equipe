package com.example.ProjetoFinalBackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_incidentes")
public class IncidentesModel {

    private Long id;
    @Column(nullable = false)
    private String gravidade;

    @Column(nullable = false, unique = true)
    private String dataHora;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String acaoImediata;

    public IncidentesModel() {
    }

    public IncidentesModel(Long id, String gravidade, String dataHora, String plataforma, String descricao, String acaoImediata) {
        this.id = id;
        this.gravidade = gravidade;
        this.dataHora = dataHora;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcaoImediata() {
        return acaoImediata;
    }

    public void setAcaoImediata(String acaoImediata) {
        this.acaoImediata = acaoImediata;
    }
}
