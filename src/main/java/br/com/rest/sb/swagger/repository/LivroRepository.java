package br.com.rest.sb.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rest.sb.swagger.model.Livro;

@Repository
public interface LivroRepository<T> extends JpaRepository<Livro, Long>{

}
