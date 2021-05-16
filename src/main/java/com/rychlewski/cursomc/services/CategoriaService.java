package com.rychlewski.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rychlewski.cursomc.domain.Categoria;
import com.rychlewski.cursomc.repositories.CategoriaRepository;

// Autowired == anotacao para instaciar automaticamente


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElse(null); 
	}

}

