package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;
import java.time.LocalDateTime;

public class IncidentesResponseDTO {

    private Long id;
    private Criticidade gravidade;
    private LocalDateTime dataSolicitacao;
    private String plataforma;
    private String descricao;
    private String acaoImediata;

    public IncidentesResponseDTO() {
    }

    public IncidentesResponseDTO(Long id, Criticidade gravidade, LocalDateTime dataSolicitacao, String plataforma, String descricao, String acaoImediata) {
        this.id = id;
        this.gravidade = gravidade;
        this.dataSolicitacao = dataSolicitacao;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Criticidade getGravidade() { return gravidade; }
    public void setGravidade(Criticidade gravidade) { this.gravidade = gravidade; }

    public LocalDateTime getDataSolicitacao() { return dataSolicitacao; }
    public void setDataSolicitacao(LocalDateTime dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getAcaoImediata() { return acaoImediata; }
    public void setAcaoImediata(String acaoImediata) { this.acaoImediata = acaoImediata; }
}