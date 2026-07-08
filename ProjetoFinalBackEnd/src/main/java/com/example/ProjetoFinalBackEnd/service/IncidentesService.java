package com.example.ProjetoFinalBackEnd.service;

import com.example.ProjetoFinalBackEnd.dto.IncidentesRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.IncidentesResponseDTO;
import com.example.ProjetoFinalBackEnd.model.IncidentesModel;
import com.example.ProjetoFinalBackEnd.repository.IncidentesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentesService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IncidentesRepository repository;

    public List<IncidentesResponseDTO> listar(){
        return repository.findAll().stream().map(incidente -> new IncidentesResponseDTO(incidente.getGravidade(), incidente.getDataHora(), incidente.getPlataforma(), incidente.getDescricao(), incidente
                .getAcaoImediata())).toList();
    }

    public IncidentesModel salvar(IncidentesRequestDTO salvarDTO){
        if(repository.findByDataHora(salvarDTO.getDataHora()).isPresent()){
            throw  new RuntimeException("Incidente já Cadastrado. ❌");
        }
        IncidentesModel novoCadastro = new IncidentesModel();
        novoCadastro.setGravidade(salvarDTO.getGravidade());
        novoCadastro.setDataHora(salvarDTO.getDataHora());
        novoCadastro.setPlataforma(salvarDTO.getPlataforma());
        novoCadastro.setDescricao(salvarDTO.getDescricao());
        novoCadastro.setAcaoImediata(salvarDTO.getAcaoImediata());

        return repository.save(novoCadastro);
    }

    public IncidentesModel atualizar(Long id, @Valid IncidentesRequestDTO atualizarDTO){
        IncidentesModel novoCadastro = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente não localizado. ❌"));

        // Verifica se o  já está em uso por OUTRO Registro
        repository.findByDataHora(atualizarDTO.getDataHora()).ifPresent(incidentes -> {
            if (!incidentes.getId().equals(id)) {
                throw new RuntimeException("Incidente já Cadastrado. ❌");
            }
        });

        novoCadastro.setGravidade(atualizarDTO.getGravidade());
        novoCadastro.setDataHora(atualizarDTO.getDataHora());
        novoCadastro.setPlataforma(atualizarDTO.getPlataforma());
        novoCadastro.setDescricao(atualizarDTO.getDescricao());
        novoCadastro.setAcaoImediata(atualizarDTO.getAcaoImediata());

        return repository.save(novoCadastro);
    }

    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cadastro não Localizado. ❌");
        }
        repository.deleteById(id);
    }

}
