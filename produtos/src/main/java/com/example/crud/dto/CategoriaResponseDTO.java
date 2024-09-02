package com.example.crud.dto;

import com.example.crud.model.Categoria;

public class CategoriaResponseDTO {
  private Long id;
  private String nome;

  public CategoriaResponseDTO(Categoria categoria) {
    this.id = categoria.getId();
    this.nome = categoria.getNome();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
