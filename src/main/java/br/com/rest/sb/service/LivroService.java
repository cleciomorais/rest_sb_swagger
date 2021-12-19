package br.com.rest.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.sb.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepo;
	
	
}
