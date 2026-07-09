package com.example.ProjetoFinalBackEnd.service;

import com.example.ProjetoFinalBackEnd.dto.TripulacaoResponseDTO;
import com.example.ProjetoFinalBackEnd.repository.TripulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripulacaoService {

    @Autowired
    private TripulacaoRepository repository;

    public List<TripulacaoResponseDTO> listarTudo() {
        return repository.findAll()
                .stream()
                .map(TripulacaoResponseDTO::new) // Utiliza o construtor do Record
                .toList();
    }
}
