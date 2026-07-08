package com.example.ProjetoFinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetoFinalBackEnd.model.ManutencaoModel;

@Repository
public interface ManutencaoRepository extends JpaRepository<ManutencaoModel,Long> {
    
}
