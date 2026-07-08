package com.example.ProjetoFinalBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class IncidentesRequestDTO {


    @NotBlank(message = "Gravidade Obrigatório ❌")
    @Size(min=3, message = "Informe a Gravidade ❌")
    private String gravidade;

    @NotBlank(message = "Data e Hora Obrigatórios ❌")
    @Size(min=11, message = "Informe a Data e Hora ❌")
    private String dataHora;

    @NotBlank(message = "Plataforma Obrigatório ❌")
    @Size(min=3, message = "Informe a Plataforma ❌")
    private String plataforma;

    @NotBlank(message = "Descrição Obrigatória ❌")
    @Size(min=5, message = "Informe a Descrição do Incidente ❌")
    private String descricao;

    @NotBlank(message = "Ação Imediata Obrigatória ❌")
    @Size(min=2, message = "Informe a Ação Tomada ❌")
    private String acaoImediata;

    public IncidentesRequestDTO() {
    }

    public IncidentesRequestDTO(String gravidade, String dataHora, String plataforma, String descricao, String acaoImediata) {
        this.gravidade = gravidade;
        this.dataHora = dataHora;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

    public @NotBlank(message = "Gravidade Obrigatório ❌") @Size(min = 3, message = "Informe a Gravidade ❌") String getGravidade() {
        return gravidade;
    }

    public void setGravidade(@NotBlank(message = "Gravidade Obrigatório ❌") @Size(min = 3, message = "Informe a Gravidade ❌") String gravidade) {
        this.gravidade = gravidade;
    }

    public @NotBlank(message = "Data e Hora Obrigatórios ❌") @Size(min = 11, message = "Informe a Data e Hora ❌") String getDataHora() {
        return dataHora;
    }

    public void setDataHora(@NotBlank(message = "Data e Hora Obrigatórios ❌") @Size(min = 11, message = "Informe a Data e Hora ❌") String dataHora) {
        this.dataHora = dataHora;
    }

    public @NotBlank(message = "Plataforma Obrigatório ❌") @Size(min = 3, message = "Informe a Plataforma ❌") String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(@NotBlank(message = "Plataforma Obrigatório ❌") @Size(min = 3, message = "Informe a Plataforma ❌") String plataforma) {
        this.plataforma = plataforma;
    }

    public @NotBlank(message = "Descrição Obrigatória ❌") @Size(min = 5, message = "Informe a Descrição do Incidente ❌") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "Descrição Obrigatória ❌") @Size(min = 5, message = "Informe a Descrição do Incidente ❌") String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank(message = "Ação Imediata Obrigatória ❌") @Size(min = 2, message = "Informe a Ação Tomada ❌") String getAcaoImediata() {
        return acaoImediata;
    }

    public void setAcaoImediata(@NotBlank(message = "Ação Imediata Obrigatória ❌") @Size(min = 2, message = "Informe a Ação Tomada ❌") String acaoImediata) {
        this.acaoImediata = acaoImediata;
    }
}
