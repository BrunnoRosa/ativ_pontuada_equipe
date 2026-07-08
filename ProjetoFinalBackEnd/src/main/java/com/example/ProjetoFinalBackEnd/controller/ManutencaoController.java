package com.example.ProjetoFinalBackEnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoFinalBackEnd.dto.ManutencaoRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.ManutencaoResponseDTO;
import com.example.ProjetoFinalBackEnd.service.ManutencaoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("api/manutencoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManutencaoController {
    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ManutencaoResponseDTO> abrirOrdemServico(@Valid @RequestBody ManutencaoRequestDTO request) {
        ManutencaoResponseDTO response = service.criarSolicitacao(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
