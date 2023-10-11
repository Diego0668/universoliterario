package com.livraria.universoliterario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.livraria.universoliterario.model.entity.Funcionario;
import com.livraria.universoliterario.model.entity.Livro;
import com.livraria.universoliterario.repository.FuncionarioRepository;
import com.livraria.universoliterario.repository.LivroRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

	final FuncionarioRepository funcionarioRepository;
	final LivroRepository livroRepository;

	public FuncionarioService(FuncionarioRepository _funcionarioRepository, LivroRepository _livroRepository) {
		super();
		this.livroRepository = _livroRepository;
		this.funcionarioRepository = _funcionarioRepository;
	}

	@Transactional
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);

	}

	public Funcionario findById(long id) {
		return funcionarioRepository.findById(id).get();
	}

	@Transactional
	public Funcionario acessar(String email, String senha) {
		Funcionario funcionario = funcionarioRepository.findByEmail(email);

		if (funcionario != null) {
			if (funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}

		return null;
	}

	@Transactional
	public void atualizarFunc(Funcionario funcionario) {
		
		funcionarioRepository.save(funcionario);

	}

	// filtro
	public List<Funcionario> TodosFuncionarios() {
		List<Funcionario> lista = funcionarioRepository.findAll();
		return lista;
	}

	// todos
	public List<Funcionario> ListarTodos() {
		return funcionarioRepository.findAll();
	}

	public List<Funcionario> FiltroFunc(String nome) {
		return funcionarioRepository.findByNomeContaining(nome);
	}

	//
	public Funcionario findByEmail(String email) {

		return funcionarioRepository.findByEmail(email);
	}

	@Transactional
	public Funcionario saveNewFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void inativarFunc(Funcionario funcionario) {

		Funcionario _funcionario = funcionario;

		_funcionario.setAcesso("INATIVO");
		funcionarioRepository.save(_funcionario);
	}

	public void inativarLivroFunc(Livro livro) {

		Livro _livro = livro;

		_livro.setPreco(0.0);
		//_livro.setQuantidade(0);
		
		_livro.setStatusLivro("INATIVO");
		livroRepository.save(_livro);
	}

}