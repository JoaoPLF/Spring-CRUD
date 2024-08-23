package com.example.crud.dto;

import jakarta.validation.constraints.Positive;

public class ProdutoUpdateDTO {
    private String nome;

    @Positive(message = "O preço do produto deve ser maior que zero.")
    private Double preco;

    @Positive(message = "O valor da avaliação deve ser maior que zero.")
    private Double avaliacao;

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
