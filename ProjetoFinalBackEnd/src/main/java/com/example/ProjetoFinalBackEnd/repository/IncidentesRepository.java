package com.example.ProjetoFinalBackEnd.repository;

import com.example.ProjetoFinalBackEnd.model.IncidentesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IncidentesRepository extends JpaRepository<IncidentesModel, Long> {

    // Método para validar duplicidade de incidente no mesmo instante de tempo
    Optional<IncidentesModel> findByDataSolicitacao(LocalDateTime dataSolicitacao);
}