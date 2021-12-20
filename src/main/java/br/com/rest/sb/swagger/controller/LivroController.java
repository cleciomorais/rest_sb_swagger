package br.com.rest.sb.swagger.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.sb.swagger.model.vo.LivroVO;
import br.com.rest.sb.swagger.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/{id}")
	public LivroVO findById(@PathVariable("id") Long id) {
		LivroVO livro = livroService.findById(id); 
		livro.add( linkTo( methodOn( LivroController.class ).findById( livro.getIdLivro() ) ).withSelfRel()  );
		return livro;
	}
	
	@GetMapping("/todos")
	public List<LivroVO> findAll() {
		List<LivroVO> livros = livroService.findAll(); 
		livros.stream().forEach( livro -> { livro.add( linkTo( methodOn( LivroController.class ).findById( livro.getIdLivro() ) ).withSelfRel()  ); } );
		return livros;
	}
	
	
	@GetMapping("")
	public String teste3() {
		return "teste ok3!";
	}
}
