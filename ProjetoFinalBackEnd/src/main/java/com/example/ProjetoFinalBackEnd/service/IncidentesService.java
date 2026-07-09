package com.example.ProjetoFinalBackEnd.service;

import com.example.ProjetoFinalBackEnd.dto.IncidentesRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.IncidentesResponseDTO;
import com.example.ProjetoFinalBackEnd.model.IncidentesModel;
import com.example.ProjetoFinalBackEnd.repository.IncidentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidentesService {

    @Autowired
    private IncidentesRepository repository;

    @Transactional(readOnly = true)
    public List<IncidentesResponseDTO> listar() {
        return repository.findAll().stream()
                .map(incidente -> new IncidentesResponseDTO(
                        incidente.getId(),
                        incidente.getGravidade(),
                        incidente.getDataSolicitacao(),
                        incidente.getPlataforma(),
                        incidente.getDescricao(),
                        incidente.getAcaoImediata()))
                .toList();
    }

    @Transactional(readOnly = true)
    public IncidentesResponseDTO buscarPorId(Long id) {
        IncidentesModel incidente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente não localizado. ❌"));
        return converterParaResponseDTO(incidente);
    }

    @Transactional
    public IncidentesResponseDTO salvar(IncidentesRequestDTO salvarDTO) {
        if (repository.findByDataSolicitacao(salvarDTO.getDataSolicitacao()).isPresent()) {
            throw new RuntimeException("Incidente já Cadastrado nesta data/hora. ❌");
        }

        IncidentesModel novoCadastro = new IncidentesModel();
        novoCadastro.setGravidade(salvarDTO.getGravidade());
        novoCadastro.setDataSolicitacao(salvarDTO.getDataSolicitacao());
        novoCadastro.setPlataforma(salvarDTO.getPlataforma());
        novoCadastro.setDescricao(salvarDTO.getDescricao());
        novoCadastro.setAcaoImediata(salvarDTO.getAcaoImediata());

        IncidentesModel salvo = repository.save(novoCadastro);
        return converterParaResponseDTO(salvo);
    }

    @Transactional
    public IncidentesResponseDTO atualizar(Long id, IncidentesRequestDTO atualizarDTO) {
        IncidentesModel registroExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente não localizado. ❌"));

        // Garante que o horário alterado não conflite com outro incidente pré-existente
        repository.findByDataSolicitacao(atualizarDTO.getDataSolicitacao()).ifPresent(incidentes -> {
            if (!incidentes.getId().equals(id)) {
                throw new RuntimeException("Já existe outro Incidente Cadastrado nesta data/hora. ❌");
            }
        });

        registroExistente.setGravidade(atualizarDTO.getGravidade());
        registroExistente.setDataSolicitacao(atualizarDTO.getDataSolicitacao());
        registroExistente.setPlataforma(atualizarDTO.getPlataforma());
        registroExistente.setDescricao(atualizarDTO.getDescricao());
        registroExistente.setAcaoImediata(atualizarDTO.getAcaoImediata());

        IncidentesModel atualizado = repository.save(registroExistente);
        return converterParaResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cadastro não Localizado. ❌");
        }
        repository.deleteById(id);
    }

    // Método auxiliar para transformar entidade persistida em objeto de saída DTO
    private IncidentesResponseDTO converterParaResponseDTO(IncidentesModel model) {
        return new IncidentesResponseDTO(
                model.getId(),
                model.getGravidade(),
                model.getDataSolicitacao(),
                model.getPlataforma(),
                model.getDescricao(),
                model.getAcaoImediata()
        );
    }
}