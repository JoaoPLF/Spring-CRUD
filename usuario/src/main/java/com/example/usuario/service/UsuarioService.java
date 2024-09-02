package com.example.usuario.service;

import org.springframework.stereotype.Service;

import com.example.usuario.dto.UsuarioDto;
import com.example.usuario.exception.UniqueException;
import com.example.usuario.model.Usuario;
import com.example.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
  final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public void cadastrar(UsuarioDto usuarioDto) {
    if (usuarioRepository.findByNome(usuarioDto.getNome()).isPresent() || usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()) {
      throw new UniqueException("Usuário já cadastrado");
    }

    Usuario usuario = new Usuario();
    usuario.setNome(usuarioDto.getNome());
    usuario.setEmail(usuarioDto.getEmail());
    usuario.setSenha(usuarioDto.getSenha());

    usuarioRepository.save(usuario);
  }
}
