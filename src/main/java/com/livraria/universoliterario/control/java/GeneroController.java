package com.livraria.universoliterario.control.java;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.universoliterario.model.entity.Genero;
import com.livraria.universoliterario.service.GeneroService;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class GeneroController {

	// Criação do objeto de serviço
	final GeneroService generoService;

	// INJEÇÃO DE DEPENDENCIA
	public GeneroController(GeneroService _GeneroService) {
		this.generoService = _GeneroService;
	}

	// ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveGenero(Genero genero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(genero));
	}

	// ROTA GET
	@GetMapping("/all")
	public ResponseEntity<List<Genero>> getAllGenero() {
		return ResponseEntity.status(HttpStatus.OK).body(generoService.findAll());
	}

}