package com.example.ProjetoFinalBackEnd.controller;

import com.example.ProjetoFinalBackEnd.dto.TripulacaoResponseDTO;
import com.example.ProjetoFinalBackEnd.service.TripulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tripulacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TripulacaoController {

    @Autowired
    private TripulacaoService service;

    @GetMapping
    public ResponseEntity<List<TripulacaoResponseDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTudo());
    }
}