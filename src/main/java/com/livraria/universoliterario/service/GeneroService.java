package com.livraria.universoliterario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.livraria.universoliterario.model.entity.Genero;
import com.livraria.universoliterario.repository.GeneroRepository;

import jakarta.transaction.Transactional;

@Service
public class GeneroService {

	// objeto repository
	final GeneroRepository generoRepository;

	// injeção de dependência
	public GeneroService(GeneroRepository _generoService) {
		this.generoRepository = _generoService;

	}

	// Metodo Insert INTO MarcaDoProduto
	@Transactional
	public Genero save(Genero _genero) {
		return generoRepository.save(_genero);
	}

	// Metodo Select * From MarcaDoProduto
	public List<Genero> findAll() {
		List<Genero> lista = generoRepository.findAll();
		return lista;
	}

}
