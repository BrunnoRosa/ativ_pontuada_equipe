package com.example.ProjetoFinalBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetoFinalBackEnd.model.ManutencaoModel;
import com.example.ProjetoFinalBackEnd.model.enums.Criticidade;


@Repository
public interface ManutencaoRepository extends JpaRepository<ManutencaoModel,Long> {

    //feat:Adicionando regras de negócio extras para futuras utilidades:

    //1: Buscar todo o histórico de manutenção de um determinado equipamento (ex: 'TC-1023')

    List<ManutencaoModel> findByEquipamentoId(String equipamentoId);

    //2: Filtrar manutenções por nível de urgência (ex: Listar apenas as 'CRÍTICA')

    List<ManutencaoModel> findByCriticidade(Criticidade criticidade);

    //3: Verificar se já existe alguma solicitação CRÍTICA aberta para o mesmo equipamento

    boolean existsByEquipamentoIdAndCriticidade(String equipamentoId, Criticidade criticidade);
    
}
