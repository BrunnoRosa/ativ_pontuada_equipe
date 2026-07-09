package com.example.ProjetoFinalBackEnd.dto;

import jakarta.validation.constraints.NotBlank;

public record TripulacaoRequestDTO(
        @NotBlank(message = "A plataforma é obrigatória.")
        String plataforma,

        @NotBlank(message = "O nome do funcionário é obrigatório.")
        String funcionario,

        @NotBlank(message = "A função é obrigatória.")
        String funcao,

        @NotBlank(message = "A data de início é obrigatória.")
        String dataInicio,

        @NotBlank(message = "A data de fim é obrigatória.")
        String dataFim,

        @NotBlank(message = "A escala é obrigatória.")
        String escala
){}