package com.spring_crud.usuario_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDto {
  @NotBlank(message = "Informe o email do usuário.")
  @Email(message = "Informe um email válido.")
  private String email;

  @NotBlank(message = "Informe uma senha.")
  private String senha;

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }
}
