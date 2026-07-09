package com.example.ProjetoFinalBackEnd.dto;

import com.example.ProjetoFinalBackEnd.model.TripulacaoModel;

public record TripulacaoResponseDTO(
        Long id,
        String plataforma,
        String funcionario,
        String funcao,
        String dataInicio,
        String dataFim,
        String escala
) {
    // Construtor de conveniência para converter a Model diretamente em DTO
    public TripulacaoResponseDTO(TripulacaoModel model) {
        this(
                model.getId(),
                model.getPlataforma(),
                model.getFuncionario(),
                model.getFuncao(),
                model.getDataInicio(),
                model.getDataFim(),
                model.getEscala()
        );
    }
}