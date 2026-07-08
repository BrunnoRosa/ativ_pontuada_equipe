package com.example.ProjetoFinalBackEnd.dto;

import java.time.LocalDateTime;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;

public class ManutencaoResponseDTO {
    private Long id;
    private String tipoCategoria;
    private String equipamentoId;
    private Criticidade criticidade;
    private String descricaoFalha;
    private LocalDateTime dataSolicitacao;
    
    
    public ManutencaoResponseDTO() {
    }

    public ManutencaoResponseDTO(Criticidade criticidade, LocalDateTime dataSolicitacao, String descricaoFalha, String equipamentoId, Long id, String tipoCategoria) {
        this.criticidade = criticidade;
        this.dataSolicitacao = dataSolicitacao;
        this.descricaoFalha = descricaoFalha;
        this.equipamentoId = equipamentoId;
        this.id = id;
        this.tipoCategoria = tipoCategoria;
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTipoCategoria() {
        return tipoCategoria;
    }


    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }


    public String getEquipamentoId() {
        return equipamentoId;
    }


    public void setEquipamentoId(String equipamentoId) {
        this.equipamentoId = equipamentoId;
    }


    public Criticidade getCriticidade() {
        return criticidade;
    }


    public void setCriticidade(Criticidade criticidade) {
        this.criticidade = criticidade;
    }


    public String getDescricaoFalha() {
        return descricaoFalha;
    }


    public void setDescricaoFalha(String descricaoFalha) {
        this.descricaoFalha = descricaoFalha;
    }


    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }


    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    
}
