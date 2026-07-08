package com.example.ProjetoFinalBackEnd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoFinalBackEnd.dto.ManutencaoRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.ManutencaoResponseDTO;
import com.example.ProjetoFinalBackEnd.service.ManutencaoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/manutencoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManutencaoController {
    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    // 1. CRIAR ORDEM DE SERVIÇO
    @PostMapping
    public ResponseEntity<ManutencaoResponseDTO> abrirOrdemServico(@Valid @RequestBody ManutencaoRequestDTO request) {
        ManutencaoResponseDTO response = service.criarSolicitacao(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. LISTAR TODAS AS MANUTENÇÕES
    @GetMapping
    public ResponseEntity<List<ManutencaoResponseDTO>> listarTodas() {
        List<ManutencaoResponseDTO> lista = service.listarTodas();
        return ResponseEntity.ok(lista);
    }

    // 3. BUSCAR MANUTENÇÃO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoResponseDTO> buscarPorId(@PathVariable Long id) {
        ManutencaoResponseDTO response = service.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    // 4. ATUALIZAR MANUTENÇÃO EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<ManutencaoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ManutencaoRequestDTO request) {
        ManutencaoResponseDTO response = service.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    // 5. DELETAR MANUTENÇÃO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
