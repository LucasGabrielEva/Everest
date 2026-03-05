package com.exampl.Everest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exampl.Everest.dto.UsuarioRequestDTO;
import com.exampl.Everest.dto.UsuarioResponseDTO;
import com.exampl.Everest.model.Formapagamento;
import com.exampl.Everest.model.UsuarioModel;
import com.exampl.Everest.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder  bCryptPasswordEncoder;

   //Consultar todos os usuários
    public List<UsuarioResponseDTO> listaTodos() {
        return usuarioRepository
        .findAll()
        .stream()
        .map(usuario -> new UsuarioResponseDTO( usuario.getNome(), usuario.getCpf(),usuario.getCnpj(),usuario.getTelefone(),usuario.getEmail(),usuario.getFormaPagamento().name()))
        .toList();
    }

    //Salvar  Usuário
    public UsuarioModel salvarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.findByCpf(dto.getCpf()).isPresent()) {
            throw new  IllegalArgumentException("Usuario já cadastrado com esse CPF");
        }

        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setCpf(dto.getCpf());
        novoUsuario.setCnpj(dto.getCnpj());
        novoUsuario.setTelefone(dto.getTelefone());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
        novoUsuario.setFormaPagamento(Formapagamento.valueOf(dto.getFormaPagamento().toUpperCase()));
        
        usuarioRepository.save(novoUsuario);
        return novoUsuario;

        
    }

    //Update
    public UsuarioModel   atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario não encontrado");
        }
        UsuarioModel atualizarUsario = new UsuarioModel();
        atualizarUsario.setId(id);
        atualizarUsario.setNome(dto.getNome());
        atualizarUsario.setCpf(dto.getCpf());
        atualizarUsario.setCnpj(dto.getCnpj());
        atualizarUsario.setTelefone(dto.getTelefone());
        atualizarUsario.setEmail(dto.getEmail());
        atualizarUsario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
        atualizarUsario.setFormaPagamento(Formapagamento.valueOf(dto.getFormaPagamento().toUpperCase()));
        
        usuarioRepository.save(atualizarUsario);
        return atualizarUsario;
    }

    //Delete
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);

    }

    
}
