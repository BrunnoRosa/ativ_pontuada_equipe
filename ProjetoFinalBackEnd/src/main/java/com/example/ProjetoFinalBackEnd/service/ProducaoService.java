package com.example.ProjetoFinalBackEnd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoFinalBackEnd.dto.ProducaoResponseDTO;
import com.example.ProjetoFinalBackEnd.model.ProducaoModel;
import com.example.ProjetoFinalBackEnd.repository.ProducaoRepository;

@Service
public class ProducaoService {

    private final ProducaoRepository repository;

    public ProducaoService(ProducaoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProducaoResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private ProducaoResponseDTO converterParaDTO(ProducaoModel model) {
        return new ProducaoResponseDTO(
            model.getId(),
            model.getPlataforma(),
            model.getPetroleoBarris(),
            model.getGasMetrosCubicos(),
            model.getMetaAtingida()
        );
    }
}