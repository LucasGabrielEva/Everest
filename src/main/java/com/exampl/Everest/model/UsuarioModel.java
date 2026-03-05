package com.exampl.Everest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_usuarios")

public class UsuarioModel {
    @Id
    @GeneratedValue
    
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private  String cpf;

    @Column(nullable = false)
    private String  cnpj;

    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String senha;

    
    @Enumerated(EnumType.STRING)
    private Formapagamento formaPagamento;
    
}
