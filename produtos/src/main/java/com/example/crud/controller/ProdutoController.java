package com.example.crud.controller;

import com.example.crud.dto.ProdutoDTO;
import com.example.crud.dto.ProdutoResponseDTO;
import com.example.crud.dto.ProdutoUpdateDTO;
import com.example.crud.repository.ProdutoRepository;
import com.example.crud.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    final ProdutoRepository produtoRepository;
    final ProdutoService produtoService;

    public ProdutoController(ProdutoRepository produtosRepository, ProdutoService produtosService) {
        this.produtoRepository = produtosRepository;
        this.produtoService = produtosService;
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return produtoService.listar();
    }

    @PostMapping
    public ProdutoResponseDTO adicionar(@Valid @RequestBody ProdutoDTO produtoDto) {
        return produtoService.adicionar(produtoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(produtoService.buscar(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateDTO novoProduto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    ProdutoResponseDTO produtoAtualizado = produtoService.atualizar(produto, novoProduto);
                    return ResponseEntity.ok().body(produtoAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produtoRepository.delete(produto);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
