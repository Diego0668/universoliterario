package com.livraria.universoliterario.control.java;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.livraria.universoliterario.model.entity.Autor;
import com.livraria.universoliterario.model.entity.Editora;
import com.livraria.universoliterario.model.entity.Livro;
import com.livraria.universoliterario.service.AutorService;
import com.livraria.universoliterario.service.EditoraService;
import com.livraria.universoliterario.service.GeneroService;
import com.livraria.universoliterario.service.LivroService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/universoliterario/livros")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class LivroController {

	final LivroService livroService;
	final GeneroService generoService;
	final AutorService autorService;
	final EditoraService editoraService;



	public LivroController(LivroService _livroService, GeneroService  _generoService, 
			AutorService  _autorService, EditoraService  _editoraService) {
		super();
		this.livroService = _livroService;
		this.generoService = _generoService;
		this.autorService = _autorService;
		this.editoraService = _editoraService;


	}
	@PostMapping("/save")
	public String gravarLivro(@RequestParam(value = "file", required = false) MultipartFile file, Livro livro,
			ModelMap model, @RequestParam String autor, @RequestParam String editora) {
		
		// código do autor
//		Autor autor1 = new Autor();
//		autor1 = autorService.findByNome(autor);
//		
//		// código da editora
//		Editora editora1 = editoraService.findByNome(editora);
//				
//		// Atualizando informações no livro
//		livro.setAutor(autor1); 	
//		livro.setEditora(editora1);
		
		livroService.gravarNovoLivro(file, livro);
		return "redirect:/universoliterario/funcionario/Estoque";
	}
	
	//tela de adicionar livro
	@GetMapping("/AdicionarLivro")
	public String getAdd(ModelMap model) {
		
		model.addAttribute("autores", autorService.findAll());
		model.addAttribute("editoras", editoraService.findAll());
		model.addAttribute("generos", generoService.findAll());
		model.addAttribute("livro", new Livro());

		return "AdicionarLivro";

	}
	//tela de estoque
	@GetMapping("/Estoque")
	public String getEstoque(ModelMap model) {

		model.addAttribute("livro", new Livro());

		return "estoque";

	}
	
	@GetMapping("/show/image/{id}")
	@ResponseBody
	public void mostrarImagem(@PathVariable("id") long id, HttpServletResponse response, Livro livro)
			throws ServletException, IOException {

		livro = livroService.findById(id);

		response.setContentType("+image/jpeg, image/jpg, image/png, image/gif");
		if (livro.getImagem() != null) {
			response.getOutputStream().write(livro.getImagem());
		} else {
			response.getOutputStream().write(null);
		}

		response.getOutputStream().close();
	}

	

}