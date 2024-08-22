package com.example.crud.controller;

import com.example.crud.dto.ProdutoUpdateDTO;
import com.example.crud.entity.Produto;
import com.example.crud.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto adicionar(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(produto -> ResponseEntity.ok().body(produto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateDTO novoProduto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    if (novoProduto.getNome() != null) {
                        produto.setNome(novoProduto.getNome());
                    }

                    if (novoProduto.getPreco() != null) {
                        produto.setPreco(novoProduto.getPreco());
                    }

                    Produto produtoAtualizado = produtoRepository.save(produto);

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
