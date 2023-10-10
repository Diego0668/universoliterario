package com.livraria.universoliterario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livraria.universoliterario.model.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
		
	// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE A TABELA
	
			List<Livro> findByTituloContaining(String titulo);
			
			List<Livro> findByStatusLivro(String status);
			
			// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE A TABELA
			@Query("SELECT l FROM Livro l WHERE l.statusLivro = 'ATIVO'")
			List<Livro> listarLivrosAtivos();
			
			@Query("SELECT l FROM Livro l WHERE l.titulo like %?1%")
			List<Livro> listarLivrosFiltro(@Param("titulo") String titulo);

		

}
