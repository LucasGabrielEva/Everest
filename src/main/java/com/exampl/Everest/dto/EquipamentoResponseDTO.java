package com.exampl.Everest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class EquipamentoResponseDTO {
    private String nome;
    private String descricao;
    private Double valor;
    private String estoque;
    private String imagem;
    
}
