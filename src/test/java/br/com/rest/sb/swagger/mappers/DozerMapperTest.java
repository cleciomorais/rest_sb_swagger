package br.com.rest.sb.swagger.mappers;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rest.sb.swagger.mapper.DozerMapper;
import br.com.rest.sb.swagger.mocks.MockLivro;
import br.com.rest.sb.swagger.model.Livro;
import br.com.rest.sb.swagger.model.vo.v1.LivroVO;


public class DozerMapperTest {

	MockLivro mockLivroClass;

    @Before
    public void setUp() {
    	mockLivroClass = new MockLivro();
    }

    @Test
    public void parseEntidadeToVoTest() {
    	Livro entidade = mockLivroClass.mockEntidade();
    	LivroVO vo = DozerMapper.parseObject(entidade, LivroVO.class);
    	
    	Assert.assertEquals(Long.valueOf(0L), vo.getIdLivro());
    	Assert.assertEquals("AUTOR0", vo.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(100L) , vo.getPreco());
    	Assert.assertEquals("TITULO0", vo.getTitulo());
    }
    
    @Test
    public void parseVoToEntidadeTest() {
    	LivroVO vo = mockLivroClass.mockVO();
    	Livro entidade = DozerMapper.parseObject(vo, Livro.class);
    	
    	Assert.assertEquals(Long.valueOf(0L), entidade.getId());
    	Assert.assertEquals("AUTOR_VO0", entidade.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(100L) , entidade.getPreco());
    	Assert.assertEquals("TITULO_VO0", entidade.getTitulo());
    }
    
    @Test
    public void parseListaEntidadeToListaVoTest() {
    	List<LivroVO> VOs = DozerMapper.parseListObjects(mockLivroClass.mockListaEntidade(), LivroVO.class);
    	
    	LivroVO vo = VOs.get(0);
    	Assert.assertEquals(Long.valueOf(1L), vo.getIdLivro());
    	Assert.assertEquals("AUTOR1", vo.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(101L) , vo.getPreco());
    	Assert.assertEquals("TITULO1", vo.getTitulo());
    	
    	vo = VOs.get(2);
    	Assert.assertEquals(Long.valueOf(3L), vo.getIdLivro());
    	Assert.assertEquals("AUTOR3", vo.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(103L) , vo.getPreco());
    	Assert.assertEquals("TITULO3", vo.getTitulo());
    	
    	vo = VOs.get(4);
    	Assert.assertEquals(Long.valueOf(5L), vo.getIdLivro());
    	Assert.assertEquals("AUTOR5", vo.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(105L) , vo.getPreco());
    	Assert.assertEquals("TITULO5", vo.getTitulo());
    }
    
    @Test
    public void parseListaVoToListaEntidadeTest() {
    	List<Livro> entidades = DozerMapper.parseListObjects(mockLivroClass.mockListaVO(), Livro.class);
    	
    	Livro entidade = entidades.get(0);
    	Assert.assertEquals(Long.valueOf(1L), entidade.getId());
    	Assert.assertEquals("AUTOR_VO1", entidade.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(101L) , entidade.getPreco());
    	Assert.assertEquals("TITULO_VO1", entidade.getTitulo());
    	
    	entidade = entidades.get(3);
    	Assert.assertEquals(Long.valueOf(4L), entidade.getId());
    	Assert.assertEquals("AUTOR_VO4", entidade.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(104L) , entidade.getPreco());
    	Assert.assertEquals("TITULO_VO4", entidade.getTitulo());
    	
    	entidade = entidades.get(2);
    	Assert.assertEquals(Long.valueOf(3L), entidade.getId());
    	Assert.assertEquals("AUTOR_VO3", entidade.getAutor());
    	Assert.assertEquals(BigDecimal.valueOf(103L) , entidade.getPreco());
    	Assert.assertEquals("TITULO_VO3", entidade.getTitulo());
    }
    
}
