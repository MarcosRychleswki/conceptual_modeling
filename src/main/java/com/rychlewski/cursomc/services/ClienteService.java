package com.rychlewski.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rychlewski.cursomc.domain.Cliente;
import com.rychlewski.cursomc.repositories.ClienteRepository;
import com.rychlewski.cursomc.services.exception.ObjectNotFoundException;

// Autowired == anotacao para instaciar automaticamente


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));  
	}

}

