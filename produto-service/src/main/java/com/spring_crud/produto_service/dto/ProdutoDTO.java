package com.spring_crud.produto_service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {
  @NotBlank(message = "Informe o nome do produto.")
  private String nome;

  @NotNull(message = "Informe o preço do produto.")
  @Positive(message = "O preço do produto deve ser maior que zero.")
  private Double preco;

  @Positive(message = "O valor da avaliação deve ser maior que zero.")
  @Max(value = 5, message = "A avaliação deve ser menor ou igual a 5.")
  private Double avaliacao;

  @NotNull(message = "Informe a categoria do produto.")
  private Long idCategoria;

  public String getNome() {
    return nome;
  }

  public Double getPreco() {
    return preco;
  }

  public Double getAvaliacao() {
    return avaliacao;
  }

  public Long getIdCategoria() {
    return idCategoria;
  }
}
