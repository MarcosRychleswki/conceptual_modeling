package com.rychlewski.cursomc.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//RestController anotaçao de controlador do app
//RequestMapping nome do end point rest

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "metodo esta funcionando";
	}
	
	
	
}
