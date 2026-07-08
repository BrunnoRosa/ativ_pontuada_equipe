package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ManutencaoRequestDTO {

    @NotBlank(message= "Campo ID do equipamento é obrigatório.")
    private String equipamentoId;

    @NotNull(message= "A criticidade(BAIXA, MÉDIA, ALTA) é obrigatória.")
    private Criticidade criticidade;

    @NotBlank(message="A descrição da falha não pode ser vazia.")
    private String descricaoFalha;

    public ManutencaoRequestDTO() {
    }

    public ManutencaoRequestDTO(@NotBlank(message = "Campo ID do equipamento é obrigatório.") String equipamentoId,
            @NotNull(message = "A criticidade(BAIXA, MÉDIA, ALTA) é obrigatória.") Criticidade criticidade,
            @NotBlank(message = "A descrição da falha não pode ser vazia.") String descricaoFalha) {
        this.equipamentoId = equipamentoId;
        this.criticidade = criticidade;
        this.descricaoFalha = descricaoFalha;
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
    

    
    
}
