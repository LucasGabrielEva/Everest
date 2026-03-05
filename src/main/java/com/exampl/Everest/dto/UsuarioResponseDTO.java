package com.exampl.Everest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UsuarioResponseDTO {
   
    private String nome;
    private String cpf;
    private String cnpj;
    private String telefone;
    private String email;
    private String formaPagamento;

    
}
