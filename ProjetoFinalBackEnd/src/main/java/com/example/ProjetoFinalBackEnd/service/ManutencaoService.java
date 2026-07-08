package com.example.ProjetoFinalBackEnd.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoFinalBackEnd.dto.ManutencaoResponseDTO;
import com.example.ProjetoFinalBackEnd.dto.ManutencaoRequestDTO;
import com.example.ProjetoFinalBackEnd.model.ManutencaoModel;
import com.example.ProjetoFinalBackEnd.repository.ManutencaoRepository;

@Service
public class ManutencaoService {
    private final ManutencaoRepository manutencaoRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    @Transactional
    public ManutencaoResponseDTO criarSolicitacao(ManutencaoRequestDTO request) {
        // Mapeando DTO para Modelo
        ManutencaoModel model = new ManutencaoModel();
        model.setEquipamentoId(request.getEquipamentoId());
        model.setCriticidade(request.getCriticidade());
        model.setDescricaoFalha(request.getDescricaoFalha());
        model.setDataSolicitacao(LocalDateTime.now()); // Gera a data de forma automática e segura em terra/mar

        // Salvando no banco MySQL
        ManutencaoModel modelSalvo = manutencaoRepository.save(model);

        // Retornando o DTO de Resposta estruturado
        return new ManutencaoResponseDTO(modelSalvo.getCriticidade(), modelSalvo.getDataSolicitacao(), modelSalvo.getDescricaoFalha(), modelSalvo.getEquipamentoId(), modelSalvo.getId(), modelSalvo.getTipoCategoria());
    }
}
