package com.example.ProjetoFinalBackEnd.model;

import java.time.LocalDateTime;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_manutencoes")
public class ManutencaoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_categoria", nullable = false)
    private String tipoCategoria = "Formulário 2";

    @Column(name = "equipamento_id", nullable = false)
    private Long equipamentoId;

    @Enumerated(EnumType.STRING)
    @Column(nullable= false)
    private Criticidade criticidade;

    @Column(name = "descricao_falha", nullable = false, columnDefinition="TEXT")
    private String descricaoFalha;

    @Column(name = "data_solicitacao", nullable= false)
    private LocalDateTime dataSolicitacao;

    public ManutencaoModel() {
    }

    public ManutencaoModel(Long id, String tipoCategoria, Long equipamentoId, Criticidade criticidade,
            String descricaoFalha, LocalDateTime dataSolicitacao) {
        this.id = id;
        this.tipoCategoria = tipoCategoria;
        this.equipamentoId = equipamentoId;
        this.criticidade = criticidade;
        this.descricaoFalha = descricaoFalha;
        this.dataSolicitacao = dataSolicitacao;
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

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
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
