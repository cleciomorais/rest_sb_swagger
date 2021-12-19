package br.com.rest.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rest.sb.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
