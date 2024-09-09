package com.spring_crud.usuario_service.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDto {
  @NotBlank(message = "Informe o nome do usuário.")
  private String nome;

  @NotBlank(message = "Informe o email do usuário.")
  @Email(message = "Informe um email válido.")
  private String email;

  @NotBlank(message = "Informe uma senha.")
  @Length(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres.")
  private String senha;

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }
}
