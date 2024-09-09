package com.spring_crud.produto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_crud.produto_service.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
