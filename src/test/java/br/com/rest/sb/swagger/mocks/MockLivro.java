package br.com.rest.sb.swagger.mocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.rest.sb.swagger.model.Livro;
import br.com.rest.sb.swagger.model.vo.v1.LivroVO;

public class MockLivro {

	public Livro mockEntidade() {
		return this.mockEntidade(0L);
	}
	
	private Livro mockEntidade(Long id) {
		Livro livro = new Livro();
		livro.setId(id);
		livro.setAutor("AUTOR" + id);
		livro.setDtLancamento( new Date() );
		livro.setPreco( new BigDecimal(100L + id) );
		livro.setTitulo("TITULO"+id);
		return livro;
	}
	
	public List<Livro> mockListaEntidade(){
		List<Livro> lista = new ArrayList<Livro>();
		lista.add( this.mockEntidade(1L));
		lista.add( this.mockEntidade(2L));
		lista.add( this.mockEntidade(3L));
		lista.add( this.mockEntidade(4L));
		lista.add( this.mockEntidade(5L));
		return lista;
	}
	
	public LivroVO mockVO() {
		return this.mockVO(0L);
	}
	
	private LivroVO mockVO(Long id) {
		LivroVO livro = new LivroVO();
		livro.setIdLivro(id);
		livro.setAutor("AUTOR_VO"+id);
		livro.setDtLancamento( new Date() );
		livro.setPreco(new BigDecimal(100L + id) );
		livro.setTitulo("TITULO_VO"+id);
		return livro;
	}
	
	public List<LivroVO> mockListaVO(){
		List<LivroVO> livros = new ArrayList<LivroVO>();
		livros.add(this.mockVO(1L));
		livros.add(this.mockVO(2L));
		livros.add(this.mockVO(3L));
		livros.add(this.mockVO(4L));
		livros.add(this.mockVO(5L));
		return livros;
	}
}
