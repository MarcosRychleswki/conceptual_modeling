package com.rychlewski.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rychlewski.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
