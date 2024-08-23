package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
