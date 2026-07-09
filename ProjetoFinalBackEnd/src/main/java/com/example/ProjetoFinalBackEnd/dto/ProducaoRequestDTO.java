package com.example.ProjetoFinalBackEnd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProducaoRequestDTO(

    @NotBlank(message = "O nome da plataforma é obrigatório.")
    String plataforma,

    @NotNull(message = "A quantidade de barris de petróleo é obrigatória.")
    @PositiveOrZero(message = "A quantidade de petróleo deve ser maior ou igual a zero.")
    Long petroleoBarris,

    @NotNull(message = "A quantidade de gás natural é obrigatória.")
    @PositiveOrZero(message = "A quantidade de gás deve ser maior ou igual a zero.")
    Long gasMetrosCubicos,

    @NotNull(message = "O status da meta deve ser informado.")
    Boolean metaAtingida
) {
}