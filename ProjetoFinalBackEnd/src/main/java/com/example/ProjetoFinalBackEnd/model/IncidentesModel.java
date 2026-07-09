package com.example.ProjetoFinalBackEnd.model;

import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_incidentes")
public class IncidentesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Criticidade gravidade;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String acaoImediata;

    public IncidentesModel() {
    }

    public IncidentesModel(Long id, Criticidade gravidade, LocalDateTime dataSolicitacao, String plataforma, String descricao, String acaoImediata) {
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