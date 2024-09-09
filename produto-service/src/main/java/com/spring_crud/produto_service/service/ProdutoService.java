package com.spring_crud.produto_service.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.spring_crud.produto_service.dto.ProdutoDTO;
import com.spring_crud.produto_service.dto.ProdutoResponseDTO;
import com.spring_crud.produto_service.dto.ProdutoUpdateDTO;
import com.spring_crud.produto_service.model.Categoria;
import com.spring_crud.produto_service.model.Produto;
import com.spring_crud.produto_service.repository.CategoriaRepository;
import com.spring_crud.produto_service.repository.ProdutoRepository;

@Service
public class ProdutoService {
  final ProdutoRepository produtoRepository;
  final CategoriaRepository categoriaRepository;

  public ProdutoService(ProdutoRepository produtosRepository, CategoriaRepository categoriaRepository) {
    this.produtoRepository = produtosRepository;
    this.categoriaRepository = categoriaRepository;
  }

  public List<ProdutoResponseDTO> listar() {
    return this.produtoRepository.findAll()
      .stream()
      .map(produto -> new ProdutoResponseDTO(produto, produto.getCategoria()))
      .toList();
  }

  public ProdutoResponseDTO adicionar(ProdutoDTO produtoDTO) {
    Produto produto = new Produto();

    produto.setNome(produtoDTO.getNome());
    produto.setPreco(produtoDTO.getPreco());
    produto.setAvaliacao(produtoDTO.getAvaliacao());

    Categoria categoria = categoriaRepository.findById(produtoDTO.getIdCategoria()).orElseThrow(() -> new NoSuchElementException("Categoria não encontrada."));

    produto.setCategoria(categoria);

    Produto novoProduto = this.produtoRepository.save(produto);

    return new ProdutoResponseDTO(novoProduto, novoProduto.getCategoria());
  }

  public ProdutoResponseDTO buscar(Long id) {
    return this.produtoRepository.findById(id)
      .map(produto -> new ProdutoResponseDTO(produto, produto.getCategoria()))
      .orElseThrow(() -> new NoSuchElementException("Produto não encontrado."));
  }

  public ProdutoResponseDTO atualizar(Produto antigoProduto, ProdutoUpdateDTO novoProduto) {
    if (novoProduto.getNome() != null) {
      antigoProduto.setNome(novoProduto.getNome());
    }

    if (novoProduto.getPreco() != null) {
      antigoProduto.setPreco(novoProduto.getPreco());
    }

    if (novoProduto.getAvaliacao() != null) {
      antigoProduto.setAvaliacao(novoProduto.getAvaliacao());
    }

    if (novoProduto.getIdCategoria() != null) {
      Categoria categoria = categoriaRepository.findById(novoProduto.getIdCategoria()).get();
      antigoProduto.setCategoria(categoria);
    }

    Produto produtoAtualizado = produtoRepository.save(antigoProduto);

    return new ProdutoResponseDTO(produtoAtualizado, produtoAtualizado.getCategoria());
  }
}
