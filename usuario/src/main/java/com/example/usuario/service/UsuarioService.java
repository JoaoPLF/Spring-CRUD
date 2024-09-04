package com.example.usuario.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.usuario.dto.LoginDto;
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

  public void registrar(UsuarioDto usuarioDto) {
    if (usuarioRepository.findByNome(usuarioDto.getNome()).isPresent() || usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()) {
      throw new UniqueException("Usuário já cadastrado");
    }

    Usuario usuario = new Usuario();
    usuario.setNome(usuarioDto.getNome());
    usuario.setEmail(usuarioDto.getEmail());
    usuario.setSenha(BCrypt.hashpw(usuarioDto.getSenha(), BCrypt.gensalt()));

    usuarioRepository.save(usuario);
  }

  public void login(LoginDto loginDto) {
    Optional<Usuario> usuario = usuarioRepository.findByEmail(loginDto.getEmail());

    if (usuario.isEmpty() || !BCrypt.checkpw(loginDto.getSenha(), usuario.get().getSenha())) {
      throw new IllegalArgumentException("Credenciais inválidas");
    }
  }
}
