package com.example.ProjetoFinalBackEnd.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoFinalBackEnd.dto.ProducaoResponseDTO;
import com.example.ProjetoFinalBackEnd.service.ProducaoService;

@RestController
@RequestMapping("/api/producao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProducaoController {

    private final ProducaoService service;

    public ProducaoController(ProducaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProducaoResponseDTO>> listarProducaoDiaria() {
        List<ProducaoResponseDTO> lista = service.listarTodas();
        return ResponseEntity.ok(lista);
    }
}