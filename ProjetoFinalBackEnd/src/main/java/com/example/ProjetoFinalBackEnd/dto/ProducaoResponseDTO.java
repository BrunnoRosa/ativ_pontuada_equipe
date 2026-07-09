package com.example.ProjetoFinalBackEnd.dto;

public record ProducaoResponseDTO(
    Long id,
    String plataforma,
    Long petroleoBarris,
    Long gasMetrosCubicos,
    Boolean metaAtingida
) {
}