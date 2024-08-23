package com.example.crud.dto;

import com.example.crud.model.Categoria;
import com.example.crud.model.Produto;

public class ProdutoResponseDTO {
  private Long id;
  private String nome;
  private Double preco;
  private Double avaliacao;
  private Long id_categoria;
  private String nome_categoria;

  public ProdutoResponseDTO(Produto produto, Categoria categoria) {
    this.id = produto.getId();
    this.nome = produto.getNome();
    this.preco = produto.getPreco();
    this.avaliacao = produto.getAvaliacao();
    this.id_categoria = categoria.getId();
    this.nome_categoria = categoria.getNome();
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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Double getAvaliacao() {
    return avaliacao;
  }

  public void setAvaliacao(Double avaliacao) {
    this.avaliacao = avaliacao;
  }

  public Long getId_categoria() {
    return id_categoria;
  }
  
  public void setId_categoria(Long id_categoria) {
    this.id_categoria = id_categoria;
  }

  public String getNome_categoria() {
    return nome_categoria;
  }

  public void setNome_categoria(String nome_categoria) {
    this.nome_categoria = nome_categoria;
  }
}
