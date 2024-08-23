package com.example.crud.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.CategoriaDTO;
import com.example.crud.dto.CategoriaResponseDTO;
import com.example.crud.model.Categoria;
import com.example.crud.repository.CategoriaRepository;

@Service
public class CategoriaService {
  @Autowired
  private CategoriaRepository categoriaRepository;

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

  public CategoriaResponseDTO atualizar(Categoria antigaCategoria, CategoriaDTO novaCategoria) {
    if (novaCategoria.getNome() != null) {
      antigaCategoria.setNome(novaCategoria.getNome());
    }

    return new CategoriaResponseDTO(this.categoriaRepository.save(antigaCategoria));
  }
}
