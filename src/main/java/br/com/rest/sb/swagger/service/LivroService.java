package br.com.rest.sb.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.sb.swagger.mapper.DozerMapper;
import br.com.rest.sb.swagger.model.vo.LivroVO;
import br.com.rest.sb.swagger.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepo;
	
	public LivroVO findById(Long id) {
		return DozerMapper.parseObject(livroRepo.findById(id) , LivroVO.class);
	}
	
	public List<LivroVO> findAll() {
		return DozerMapper.parseListObjects(livroRepo.findAll() , LivroVO.class);
	}
	
	
}
