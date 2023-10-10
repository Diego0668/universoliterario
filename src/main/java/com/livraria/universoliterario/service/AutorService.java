package com.livraria.universoliterario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.livraria.universoliterario.model.entity.Autor;
import com.livraria.universoliterario.repository.AutorRepository;

import jakarta.transaction.Transactional;

@Service
public class AutorService {

	// objeto repository
	final AutorRepository autorRepository;

	// injeção de dependência
	public AutorService(AutorRepository _autorService) {
		this.autorRepository = _autorService;

	}

	// Metodo Insert INTO Autor
	@Transactional
	public Autor save(Autor _autor) {
		return autorRepository.save(_autor);
	}

	// Metodo Select * From Autor
	public List<Autor> findAll() {
		List<Autor> lista = autorRepository.findAll();
		return lista;
	}
	
	// Pesquisar 1 autor
	public Autor findByNome(String _nome) {
		Autor autor = autorRepository.findByNome(_nome);
		return autor;
	}

}
