package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;

public class IncidentesResponseDTO {

    private Criticidade gravidade;
    private String dataHora;
    private String plataforma;
    private String descricao;
    private String acaoImediata;

    public IncidentesResponseDTO() {
    }

    public IncidentesResponseDTO(Criticidade gravidade, String dataHora, String plataforma, String descricao, String acaoImediata) {
        this.gravidade = gravidade;
        this.dataHora = dataHora;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

    public Criticidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(Criticidade gravidade) {
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
