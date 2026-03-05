package com.exampl.Everest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EquipamentoRequestDTO {

@NotBlank(message = "O nome é obrigatório")
private String nome;

@NotBlank(message = "A descrição é obrigatória")
private String descricao;

@NotBlank(message = "O valor é obrigatório")
private Double valor;

@NotBlank(message = "O estoque é obrigatório")
private String estoque;

@NotBlank(message = "A imagem é obrigatória")
private String imagem;


    
}
