package com.example.ProjetoFinalBackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_producao_diaria")
public class ProducaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plataforma;
    private Long petroleoBarris;
    private Long gasMetrosCubicos;
    private Boolean metaAtingida;

    public ProducaoModel() {
    }

    public ProducaoModel(Long id, String plataforma, Long petroleoBarris, Long gasMetrosCubicos, Boolean metaAtingida) {
        this.id = id;
        this.plataforma = plataforma;
        this.petroleoBarris = petroleoBarris;
        this.gasMetrosCubicos = gasMetrosCubicos;
        this.metaAtingida = metaAtingida;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Long getPetroleoBarris() {
        return petroleoBarris;
    }

    public void setPetroleoBarris(Long petroleoBarris) {
        this.petroleoBarris = petroleoBarris;
    }

    public Long getGasMetrosCubicos() {
        return gasMetrosCubicos;
    }

    public void setGasMetrosCubicos(Long gasMetrosCubicos) {
        this.gasMetrosCubicos = gasMetrosCubicos;
    }

    public Boolean getMetaAtingida() {
        return metaAtingida;
    }

    public void setMetaAtingida(Boolean metaAtingida) {
        this.metaAtingida = metaAtingida;
    }
}