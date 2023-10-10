package com.livraria.universoliterario.control.java;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.universoliterario.model.entity.Editora;
import com.livraria.universoliterario.service.EditoraService;

@RestController
@RequestMapping("/editoras")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class EditoraController {

	// Criação do objeto de serviço
	final EditoraService editoraService;

	// INJEÇÃO DE DEPENDENCIA
	public EditoraController(EditoraService _EditoraService) {
		this.editoraService = _EditoraService;
	}

	// ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveEditora(Editora editora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.save(editora));
	}

	// ROTA GET
	@GetMapping("/all")
	public ResponseEntity<List<Editora>> getAllEditora() {
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.findAll());
	}

}