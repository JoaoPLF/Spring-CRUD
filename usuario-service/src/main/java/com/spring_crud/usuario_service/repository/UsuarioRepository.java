package com.spring_crud.usuario_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_crud.usuario_service.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByNome(String nome);
  Optional<Usuario> findByEmail(String email);
}
