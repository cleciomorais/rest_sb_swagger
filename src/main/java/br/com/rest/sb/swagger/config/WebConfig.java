package br.com.rest.sb.swagger.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.rest.sb.swagger.converter.YamlJackson2HttpMessageConverter;;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
  /*
   * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA NA URL. EX:
   * http://localhost:8080/livro/v1/all.xml ou /all.json
   */
//  @Override
//  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    configurer.favorParameter(false)
//	  			.ignoreAcceptHeader(false)
//	  			.defaultContentType(MediaType.APPLICATION_JSON)
//	  			.mediaType("xml", MediaType.APPLICATION_XML)
//	  			.mediaType("json", MediaType.APPLICATION_JSON);
//  }
	
	/*
	 * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA VIA PARAMETRO NA URL. EX:
	 * http://localhost:8080/livro/v1/all?media_type=json ou /all?media_type=xml
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
			.favorPathExtension(false)
			.favorParameter(true)
			.parameterName("media_type")
			.ignoreAcceptHeader(true)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("x-yaml", MEDIA_TYPE_YML); // configuração para o tipo yml
			
	}
	
	/*
	 * CONFIGURAÇÃO PARA PASSAR A EXTENÇÃO DESEJADA VIA PARAMETRO DO HEADER DA MENSAGEM HTML:
	 * EX: http://localhost:8080/livro/v1/all
	 * KEY   = Accept
	 * VALUE = application/json ou application/xml 
	 * 
	 */
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer
//			.favorPathExtension(false)
//			.favorParameter(false)
//			.ignoreAcceptHeader(false)
//			.useRegisteredExtensionsOnly(false)
//			.defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML)
//			.mediaType("json", MediaType.APPLICATION_JSON);
//			
////		    .mediaType("x-yaml", MEDIA_TYPE_YML); // configuração para o tipo yml
//	}
	

	/*
	 * CONFIGURAÇÃO PARA TRATAR O YAML 
	 * */
	public void extendMessageConverters( List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
		
	}
}
