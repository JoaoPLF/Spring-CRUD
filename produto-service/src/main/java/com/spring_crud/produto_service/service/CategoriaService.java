package com.spring_crud.produto_service.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.spring_crud.produto_service.dto.CategoriaDTO;
import com.spring_crud.produto_service.dto.CategoriaResponseDTO;
import com.spring_crud.produto_service.dto.CategoriaUpdateDTO;
import com.spring_crud.produto_service.model.Categoria;
import com.spring_crud.produto_service.repository.CategoriaRepository;

@Service
public class CategoriaService {
  final CategoriaRepository categoriaRepository;

  public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public List<CategoriaResponseDTO> listar() {
    return this.categoriaRepository.findAll().stream().map(categoria -> new CategoriaResponseDTO(categoria)).toList();
  }

  public CategoriaResponseDTO adicionar(CategoriaDTO categoriaDTO) {
    Categoria categoria = new Categoria();

    categoria.setNome(categoriaDTO.getNome());

    return new CategoriaResponseDTO(this.categoriaRepository.save(categoria));
  }

  public CategoriaResponseDTO buscar(Long id) {
    return this.categoriaRepository.findById(id)
      .map(categoria -> new CategoriaResponseDTO(categoria))
      .orElseThrow(() -> new NoSuchElementException("Produto não encontrado."));
  }

  public CategoriaResponseDTO atualizar(Categoria antigaCategoria, CategoriaUpdateDTO novaCategoria) {
    if (novaCategoria.getNome() != null) {
      antigaCategoria.setNome(novaCategoria.getNome());
    }

    return new CategoriaResponseDTO(this.categoriaRepository.save(antigaCategoria));
  }
}
