package com.example.ProjetoFinalBackEnd.controller;

import com.example.ProjetoFinalBackEnd.dto.IncidentesRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.IncidentesResponseDTO;
import com.example.ProjetoFinalBackEnd.service.IncidentesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
public class IncidentesController {

    @Autowired
    private IncidentesService service;

    @GetMapping
    public ResponseEntity<List<IncidentesResponseDTO>> listarTodos() {
        List<IncidentesResponseDTO> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentesResponseDTO> buscarPorId(@PathVariable Long id) {
        IncidentesResponseDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<IncidentesResponseDTO> criar(@RequestBody @Valid IncidentesRequestDTO dto) {
        IncidentesResponseDTO novoIncidente = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIncidente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentesResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid IncidentesRequestDTO dto) {
        IncidentesResponseDTO incidenteAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(incidenteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}