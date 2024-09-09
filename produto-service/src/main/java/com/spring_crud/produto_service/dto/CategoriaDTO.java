package com.spring_crud.produto_service.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {
  @NotBlank(message = "Informe o nome da categoria.")
  private String nome;

  public String getNome() {
    return nome;
  }
}
