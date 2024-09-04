package com.example.usuario.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.dto.LoginDto;
import com.example.usuario.dto.UsuarioDto;
import com.example.usuario.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @PostMapping("/registrar")
  public String registrarUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
    usuarioService.registrar(usuarioDto);
    return "Ok";
  }

  @PostMapping("/login")
  public String login(@Valid @RequestBody LoginDto loginDto) {
    usuarioService.login(loginDto);

    return "OK";
  }
}
