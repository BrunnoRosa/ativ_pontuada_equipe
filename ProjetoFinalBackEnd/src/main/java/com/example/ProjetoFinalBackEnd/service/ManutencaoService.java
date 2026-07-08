package com.example.ProjetoFinalBackEnd.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoFinalBackEnd.dto.ManutencaoRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.ManutencaoResponseDTO;
import com.example.ProjetoFinalBackEnd.model.ManutencaoModel;
import com.example.ProjetoFinalBackEnd.repository.ManutencaoRepository;

@Service
public class ManutencaoService {
    private final ManutencaoRepository manutencaoRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    // 1. CRIAR SOLICITAÇÃO
    @Transactional
    public ManutencaoResponseDTO criarSolicitacao(ManutencaoRequestDTO request) {
        ManutencaoModel model = new ManutencaoModel();
        model.setEquipamentoId(request.getEquipamentoId());
        model.setCriticidade(request.getCriticidade());
        model.setDescricaoFalha(request.getDescricaoFalha());
        model.setDataSolicitacao(LocalDateTime.now()); // Gera a data de forma automática

        ManutencaoModel modelSalvo = manutencaoRepository.save(model);

        return converterParaDTO(modelSalvo);
    }

    // 2. LISTAR TODAS AS SOLICITAÇÕES
    @Transactional(readOnly = true)
    public List<ManutencaoResponseDTO> listarTodas() {
        return manutencaoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // 3. BUSCAR POR ID
    @Transactional(readOnly = true)
    public ManutencaoResponseDTO buscarPorId(Long id) {
        ManutencaoModel model = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada para o ID: " + id));

        return converterParaDTO(model);
    }

    // 4. ATUALIZAR
    @Transactional
    public ManutencaoResponseDTO atualizar(Long id, ManutencaoRequestDTO request) {
        ManutencaoModel model = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada para o ID: " + id));

        // Atualiza os dados recebidos no DTO
        model.setEquipamentoId(request.getEquipamentoId());
        model.setCriticidade(request.getCriticidade());
        model.setDescricaoFalha(request.getDescricaoFalha());
        // Obs: A data de solicitação original é mantida intacta

        ManutencaoModel modelAtualizado = manutencaoRepository.save(model);

        return converterParaDTO(modelAtualizado);
    }

    // 5. DELETAR
    @Transactional
    public void deletar(Long id) {
        if (!manutencaoRepository.existsById(id)) {
            throw new RuntimeException("Ordem de serviço não encontrada para o ID: " + id);
        }
        manutencaoRepository.deleteById(id);
    }

    // --- MÉTODO AUXILIAR PARA REUSO DE CÓDIGO ---
    private ManutencaoResponseDTO converterParaDTO(ManutencaoModel model) {
        return new ManutencaoResponseDTO(
            model.getCriticidade(),
            model.getDataSolicitacao(),
            model.getDescricaoFalha(),
            model.getEquipamentoId(),
            model.getId(),
            model.getTipoCategoria()
        );
    }
}
