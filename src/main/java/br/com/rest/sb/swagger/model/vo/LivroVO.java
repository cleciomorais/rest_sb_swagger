package br.com.rest.sb.swagger.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder ({"id", "autor", "dtLancamento", "preco", "titulo"})
public class LivroVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 12484267971799999L;

	@Mapping("id")
	@JsonProperty("id")
	private Long idLivro;
	
	@Mapping("autor")
	private String autor;
	
	@Mapping("dtLancamento")
	private LocalDateTime dtLancamento;
	
	@Mapping("preco")
	private BigDecimal preco;

	@Mapping("titulo")
	private String titulo;

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDateTime getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(LocalDateTime dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
