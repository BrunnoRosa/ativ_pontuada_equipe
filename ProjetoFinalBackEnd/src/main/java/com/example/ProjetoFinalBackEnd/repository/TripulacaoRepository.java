package com.example.ProjetoFinalBackEnd.repository;

import com.example.ProjetoFinalBackEnd.model.TripulacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripulacaoRepository extends JpaRepository<TripulacaoModel, Long> {
}