package br.com.rest.sb.swagger.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public YamlJackson2HttpMessageConverter() {
		super(new YAMLMapper()  
				//.setSerializationInclusion(JsonInclude.Include.NON_NULL) serve para não serializar as propriedades nulas dos objetos para o yml de retorno
				.setSerializationInclusion(JsonInclude.Include.NON_NULL) , MediaType.parseMediaType("application/x-yaml") );
	}

}
