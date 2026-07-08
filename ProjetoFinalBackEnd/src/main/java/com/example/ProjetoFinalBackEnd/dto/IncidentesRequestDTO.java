package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IncidentesRequestDTO {


    @NotNull(message= "A criticidade(BAIXA, MÉDIA, ALTA) é obrigatória.")
    private Criticidade gravidade;

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

    public IncidentesRequestDTO(Criticidade gravidade, String dataHora, String plataforma, String descricao, String acaoImediata) {
        this.gravidade = gravidade;
        this.dataHora = dataHora;
        this.plataforma = plataforma;
        this.descricao = descricao;
        this.acaoImediata = acaoImediata;
    }

    public @NotNull(message = "A criticidade(BAIXA, MÉDIA, ALTA) é obrigatória.") Criticidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(@NotNull(message = "A criticidade(BAIXA, MÉDIA, ALTA) é obrigatória.") Criticidade gravidade) {
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
