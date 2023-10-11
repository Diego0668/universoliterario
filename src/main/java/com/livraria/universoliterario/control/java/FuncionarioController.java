package com.livraria.universoliterario.control.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.livraria.universoliterario.model.entity.Funcionario;
import com.livraria.universoliterario.service.AutorService;
import com.livraria.universoliterario.service.EditoraService;
import com.livraria.universoliterario.service.FuncionarioService;
import com.livraria.universoliterario.service.GeneroService;
import com.livraria.universoliterario.service.LivroService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/universoliterario/funcionario")
//@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioController {

	// CRIAÇÃO DO OBJETO DE SERVIÇO
	final LivroService livroService;
	final FuncionarioService funcionarioService;
	final GeneroService generoService;
	final AutorService autorService;
	final EditoraService editoraService;


	// INJEÇÃO DE DEPENDENCIA

	public FuncionarioController(FuncionarioService _funcionarioService, GeneroService _generoService,
			AutorService _autorService, EditoraService _editoraService, LivroService _livroService) {
		this.funcionarioService = _funcionarioService;
		this.generoService = _generoService;
		this.autorService = _autorService;
		this.editoraService = _editoraService;
		this.livroService = _livroService;

	}

	@GetMapping("/login")
	public String getLogin(ModelMap model) {

		model.addAttribute("funcionario", new Funcionario());

		return "login";

	}
	
	

	@GetMapping("/criarconta")
	public String getConta(ModelMap model) {

		model.addAttribute("funcionario", new Funcionario());
	
		return "CriarConta";

	}
	
	@GetMapping("/Estoque")
	public String getEstoque(ModelMap model) {

		model.addAttribute("funcionario", new Funcionario());
	
		return "estoque";

	}
	
	
	
	
	@PostMapping("/logar")
	public String Acessar(ModelMap map, 
			@RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session) {
		
		Funcionario funclogado = funcionarioService.Acessar(email, senha);

		if (funclogado != null) {
			session.setAttribute("funclogado", funclogado);
			if (funclogado.getAcesso().equals("func")) {
				
				return "redirect:/universoliterario/livros/Estoque";
			} else if (funclogado.getAcesso().equals("adm")) {
				
	
				return "redirect:/universoliterario/livros/AdicionarLivro";
			}
		}

		return "redirect:/universoliterario/funcionario/login";
	}
	

	@PostMapping("/save")
	public String saveFuncionario(@ModelAttribute Funcionario funcionario) {

		funcionario.setAcesso("func");

		funcionarioService.saveNewFuncionario(funcionario);

		return "redirect:/universoliterario/funcionario/login";
	}
	
	@GetMapping("/inativar/{id}")
	public String inativarFunc(@PathVariable("id") int id, ModelMap model) {

		Funcionario funcionario = funcionarioService.findById(id);

		funcionarioService.inativarFunc(funcionario);

		return "redirect:/lifetree/funcionario/ListaFunc";
	}


	

}