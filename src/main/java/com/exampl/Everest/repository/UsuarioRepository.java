package com.exampl.Everest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampl.Everest.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByCpf(String cpf);
    
}
