package com.example.crud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dto.CategoriaDTO;
import com.example.crud.dto.CategoriaResponseDTO;
import com.example.crud.dto.CategoriaUpdateDTO;
import com.example.crud.repository.CategoriaRepository;
import com.example.crud.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
  final CategoriaRepository categoriaRepository;
  final CategoriaService categoriaService;

  public CategoriaController(CategoriaRepository categoriaRepository, CategoriaService categoriaService) {
    this.categoriaRepository = categoriaRepository;
    this.categoriaService = categoriaService;
  }

  @GetMapping
  public List<CategoriaResponseDTO> listar() {
    return categoriaService.listar();
  }

  @PostMapping
  public CategoriaResponseDTO adicionar(@Valid @RequestBody CategoriaDTO categoriaDto) {
      return categoriaService.adicionar(categoriaDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoriaResponseDTO> buscar(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(categoriaService.buscar(id));
  } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
  }
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaUpdateDTO novaCategoria) {
    return categoriaRepository.findById(id)
                .map(categoria -> {
                    CategoriaResponseDTO categoriaAtualizada = categoriaService.atualizar(categoria, novaCategoria);
                    return ResponseEntity.ok().body(categoriaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletar(@PathVariable Long id) {
    return categoriaRepository.findById(id)
        .map(categoria -> {
          categoriaRepository.delete(categoria);
          return ResponseEntity.ok().build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
