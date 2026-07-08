package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class IncidentesRequestDTO {

    @NotNull(message = "A gravidade não pode ser nula.")
    private Criticidade gravidade;

    @NotNull(message = "A data de solicitação não pode ser nula.")
    private LocalDateTime dataSolicitacao;

    @NotBlank(message = "A plataforma não pode estar em branco.")
    private String plataforma;

    @NotBlank(message = "A descrição não pode estar em branco.")
    private String descricao;

    @NotBlank(message = "A ação imediata não pode estar em branco.")
    private String acaoImediata;

    public IncidentesRequestDTO() {
    }

    public IncidentesRequestDTO(Criticidade gravidade, LocalDateTime dataSolicitacao, String plataforma, String descricao, String acaoImediata) {
        this.gravidade = gravidade;
        this.dataSolicitacao = dataSolicitacao;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

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