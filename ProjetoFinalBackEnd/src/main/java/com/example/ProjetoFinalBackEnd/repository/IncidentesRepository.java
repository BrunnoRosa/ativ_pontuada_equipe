package com.example.ProjetoFinalBackEnd.repository;

import com.example.ProjetoFinalBackEnd.model.IncidentesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncidentesRepository extends JpaRepository<IncidentesModel, Long> {

    Optional<IncidentesModel> findByDataHora(String dataHora);
}
