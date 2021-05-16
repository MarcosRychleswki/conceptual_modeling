package com.rychlewski.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rychlewski.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
