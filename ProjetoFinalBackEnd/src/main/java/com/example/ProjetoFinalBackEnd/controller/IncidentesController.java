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
import java.util.Map;

@RestController
@RequestMapping("api/incidentes")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncidentesController {

    @Autowired
    private IncidentesService service;

    @GetMapping
    public ResponseEntity<List<IncidentesResponseDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody @Valid IncidentesRequestDTO salvarDTO){
        service.salvar(salvarDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Registro Realizado com Sucesso. ✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody @Valid IncidentesRequestDTO salvarDTO){
        service.atualizar(id, salvarDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Registro Atualizado com Sucesso. ✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Registro deletado com Sucesso. ✅"));
    }
}
