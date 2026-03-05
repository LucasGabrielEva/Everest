package com.exampl.Everest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampl.Everest.model.EquipamentoModel;

public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {
    Optional<EquipamentoModel>findByNome(String nome);


    
}
