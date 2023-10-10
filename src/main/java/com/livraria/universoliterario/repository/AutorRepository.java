package com.livraria.universoliterario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.universoliterario.model.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	Autor findByNome(String nome);

}
