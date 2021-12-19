package br.com.rest.sb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVROS")
public class Livro implements Serializable {

	private static final long serialVersionUID = 7894266328610717933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "AUTOR", nullable = true)
	private String autor;
	
	@Column(name = "DTLANCAMENTO", nullable = false)
	private LocalDateTime dtLancamento;
	
	@Column(name = "PRECO", nullable = false)
	private BigDecimal preco;

	@Column(name = "TITULO", nullable = true) 
	private String titulo;
}
