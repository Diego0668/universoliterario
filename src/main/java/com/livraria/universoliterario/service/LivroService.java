package com.livraria.universoliterario.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.livraria.universoliterario.model.entity.Livro;
import com.livraria.universoliterario.repository.AutorRepository;
import com.livraria.universoliterario.repository.EditoraRepository;
import com.livraria.universoliterario.repository.GeneroRepository;
import com.livraria.universoliterario.repository.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class LivroService {

	// objeto repository
	private LivroRepository livroRepository;
	private GeneroRepository generoRepository;
	private AutorRepository autorRepository;
	private EditoraRepository editoraRepository;


	// Injeção de dependência
	public LivroService(LivroRepository _livroRepository, GeneroRepository _generoRepository,
			 AutorRepository _autorRepository,  EditoraRepository _editoraRepository) {
		super();
		this.livroRepository = _livroRepository;
		this.generoRepository =_generoRepository;
		this.autorRepository =_autorRepository;
		this.editoraRepository = _editoraRepository;
		
	
	}



	public Livro findById(long id) {
		return livroRepository.findById(id).get();
	}

	public List<Livro> ListarTodos() {
		return livroRepository.findAll();

	}
	
	
	
	//Aqui pesquisar
	public List<Livro> listarTodosFiltro(String nome) {
		return null; // livroRepository.findByNomeContaining(nome);
	
	
	}

	@Transactional
	public void inativarLivro(Livro livro) {

		Livro _livro = livro;

		_livro.setPreco(0.0);
		//_livro.setQuantidade(0);
		
		_livro.setStatusLivro("INATIVO");
		livroRepository.save(_livro);
	}

	@Transactional
	public void reativarLivro(Livro livro) {

		Livro _livro = livro;

	

		_livro.setStatusLivro("ATIVO");
		livroRepository.save(_livro);
	}

	@Transactional
	public Livro gravarNovoLivro(MultipartFile file, Livro livro) {

		if (file != null && file.getSize() > 0) {
			try {
				livro.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			livro.setImagem(null);
		}
		return livroRepository.save(livro);
	}


	@Transactional
	public void atualizarLivro(MultipartFile file, Livro _livro, byte[] foto) {

		
		if (file.getSize() == 0 && foto.length == 0) {
			_livro.setImagem(null);
		}

		if (file.getSize() == 0 && foto.length > 0) {
			_livro.setImagem(foto);
		}

		if (file != null && file.getSize() > 0) {
			try {
				_livro.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}



		_livro.setStatusLivro("ATIVO");
		livroRepository.save(_livro);
	}

	// METODO INSERT INTO livro
	@Transactional
	public Livro save(Livro _livro) {
		return livroRepository.save(_livro);
	}

	// METODO SELECT * FROM livro
	public List<Livro> ListarTodosLivro() {
		List<Livro> lista = livroRepository.findAll();
		return lista;
	}



	public GeneroRepository getGeneroRepository() {
		return generoRepository;
	}



	public void setGeneroRepository(GeneroRepository generoRepository) {
		this.generoRepository = generoRepository;
	}



	public AutorRepository getAutorRepository() {
		return autorRepository;
	}



	public void setAutorRepository(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}



	public EditoraRepository getEditoraRepository() {
		return editoraRepository;
	}



	public void setEditoraRepository(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	
}
