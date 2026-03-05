package com.exampl.Everest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampl.Everest.dto.EquipamentoRequestDTO;
import com.exampl.Everest.model.EquipamentoModel;
import com.exampl.Everest.model.Estoque;
import com.exampl.Everest.repository.EquipamentoRepository;

@Service
public class EquipamentoService {
    @Autowired
    private  EquipamentoRepository equipamentoRepository;

    //Consultar Equipamentos
    public  List<EquipamentoModel> listaTodos(){
        return equipamentoRepository
        .findAll()
        .stream()
        .map(e -> new EquipamentoModel(e.getId(), e.getNome(), e.getDescricao(), e.getValor(), e.getEstoque(), e.getImagem()))
        .toList();
    
    }
    //Salvar Equipamento
    public EquipamentoModel  salvarEquipamento(EquipamentoRequestDTO dto) {
        if (equipamentoRepository.findByNome(dto.getNome()).isPresent()) {
            throw new RuntimeException("Equipamento já cadastrado");
        }
        EquipamentoModel novoEquipameto = new EquipamentoModel();
        novoEquipameto.setNome(dto.getNome());
        novoEquipameto.setDescricao(dto.getDescricao());
        novoEquipameto.setValor(dto.getValor());
        novoEquipameto.setEstoque(Estoque.valueOf(dto.getEstoque().toUpperCase()));
        novoEquipameto.setImagem(dto.getImagem());
        
        equipamentoRepository.save(novoEquipameto);
        return novoEquipameto;
        
    }

    //Atualização de Equipamentos
    public  EquipamentoModel atualizarEquipamento(Long id, EquipamentoRequestDTO dto) {
        if (!equipamentoRepository.existsById(id)) {
            throw new RuntimeException("Equipamento não encontrado");
        }
        EquipamentoModel atualizarEquipamento = new EquipamentoModel();
        atualizarEquipamento.setId(id);
        atualizarEquipamento.setNome(dto.getNome());
        atualizarEquipamento.setDescricao(dto.getDescricao());
        atualizarEquipamento.setValor(dto.getValor());
        atualizarEquipamento.setEstoque(Estoque.valueOf(dto.getEstoque().toUpperCase()));
        atualizarEquipamento.setImagem(dto.getImagem());

        equipamentoRepository.save(atualizarEquipamento);
        return atualizarEquipamento;
    }

    //Deletar
    public void deletarEquipamento(Long id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new RuntimeException("Equipamento não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }


    
}
