package com.example.crud.dto;

import jakarta.validation.constraints.Positive;

public class ProdutoUpdateDTO {
    private String nome;

    @Positive(message = "O preço do produto deve ser maior que zero.")
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
