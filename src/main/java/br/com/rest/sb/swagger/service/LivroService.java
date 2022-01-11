package br.com.rest.sb.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rest.sb.swagger.mapper.DozerMapper;
import br.com.rest.sb.swagger.model.Livro;
import br.com.rest.sb.swagger.model.vo.v1.LivroVO;
import br.com.rest.sb.swagger.repository.LivroRepository;

@Service
public class LivroService {

	
	@Autowired
	LivroRepository<Livro> livroRepo;
	
	public LivroVO create(LivroVO livro) {
		Livro entidade = DozerMapper.parseObject(livro, Livro.class);
		return DozerMapper.parseObject(livroRepo.save(entidade)  , LivroVO.class); 
	}
	
	public LivroVO findById(Long id) {
		Livro livro = livroRepo.findById( id ).orElseThrow(() -> new  ResourceNotFoundException("Registro não encontrado!"));
		return DozerMapper.parseObject(livro , LivroVO.class);
	}
	
	public List<LivroVO> findAll() {
		return DozerMapper.parseListObjects(livroRepo.findAll() , LivroVO.class);
	}
	
	public void delete(Long id) {
		Livro livro = livroRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Não existe livro com ID informado para ser deletado!") );
		livroRepo.delete(livro);
	}
}
