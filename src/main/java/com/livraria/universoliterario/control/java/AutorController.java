package com.livraria.universoliterario.control.java;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.universoliterario.model.entity.Autor;
import com.livraria.universoliterario.service.AutorService;

@RestController
@RequestMapping("/autores")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class AutorController {

	// Criação do objeto de serviço
	final AutorService autorService;

	// INJEÇÃO DE DEPENDENCIA
	public AutorController(AutorService _autorService) {
		this.autorService = _autorService;
	}

	// ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveAutor(Autor autor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autorService.save(autor));
	}

	// ROTA GET
	@GetMapping("/all")
	public ResponseEntity<List<Autor>> getAllAutor() {
		return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
	}
	
}