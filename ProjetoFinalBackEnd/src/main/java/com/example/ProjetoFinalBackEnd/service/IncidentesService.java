package com.example.ProjetoFinalBackEnd.service;

import com.example.ProjetoFinalBackEnd.dto.IncidentesRequestDTO;
import com.example.ProjetoFinalBackEnd.dto.IncidentesResponseDTO;
import com.example.ProjetoFinalBackEnd.model.IncidentesModel;
import com.example.ProjetoFinalBackEnd.repository.IncidentesRepository;
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
        return repository.findAll().stream().map(funcionario -> new IncidentesResponseDTO(funcionario.getGravidade(), funcionario.getDataHora(), funcionario.getPlataforma(), funcionario.getDescricao(), funcionario.getAcaoImediata())).toList();
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

    public IncidentesModel atualizar(Long id, IncidentesModel atualizarDTO){
        String dataHora = "";
        IncidentesModel novoCadastro = repository.findByDataHora(dataHora)
                .orElseThrow(() -> new IllegalArgumentException("Cadastro não localizado. ❌"));

        // Verifica se o  já está em uso por OUTRO Registro
        repository.findByDataHora(atualizarDTO.getDataHora()).ifPresent(incidentes -> {
            if (!incidentes.getId().equals(dataHora)) {
                throw new RuntimeException("Funcionário já Cadastrado. ❌");
            }
        });

        novoCadastro.setNome(atualizarDTO.getNome());
        novoCadastro.setTelefone(atualizarDTO.getTelefone());
        novoCadastro.setEmail(atualizarDTO.getEmail());
        novoCadastro.setCargo(atualizarDTO.getCargo());
        novoCadastro.setSetor(atualizarDTO.getSetor());

        return repository.save(novoCadastro);
    }

    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cadastro não Localizado. ❌");
        }
        repository.deleteById(id);
    }

}
