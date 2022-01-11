package br.com.rest.sb.swagger.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.sb.swagger.model.vo.v1.LivroVO;
import br.com.rest.sb.swagger.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Livro Endpoint", description = "Endpoint with paths to maintain a Book treatment options", tags = {"livro-endpoint"})
@RestController
@RequestMapping("/livro/v1")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@ApiOperation (value = "Path to create a new Book entity")
	@PostMapping(value = "/add", 
			produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public LivroVO create(@RequestBody LivroVO livro) {
		return livroService.create(livro);
	}
	
	@ApiOperation (value = "Path to find a especific Book by id")
	@GetMapping(value = "/get/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public LivroVO findById(@PathVariable("id") Long id) {
		LivroVO livro = livroService.findById(id); 
		livro.add( linkTo( methodOn( LivroController.class ).findById( livro.getIdLivro() ) ).withSelfRel()  );
		return livro;
	}
	
	@ApiOperation (value = "Path to find all Books recorded in database")
	@GetMapping(value = "/all", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<LivroVO> findAll() {
		List<LivroVO> livros = livroService.findAll(); 
		livros
			.stream()
			.forEach( livro -> { 
						livro.add( 
							linkTo( methodOn( LivroController.class ).findById( livro.getIdLivro() ) ).withSelfRel()  
						); 
					  } 
					);
		return livros;
	}
	
	@ApiOperation (value = "Path to delete a existent Book from database")
	@DeleteMapping(value = "/del/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> delete(@PathVariable ("id") Long id){ 
		livroService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
