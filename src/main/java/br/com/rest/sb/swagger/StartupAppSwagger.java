package br.com.rest.sb.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration // adicionada quando o hateoas foi incluído
//						//permitir que o application context do spring seja automaticamente carregado de acordo com os .jars e configurações definidas
//						//depois que os beans já foram registrados no application context
//@ComponentScan			//fala para o springboot scanear os pacotes da app e encontrar arquivos de configuracao como o WebConfig.java
public class StartupAppSwagger {

	public static void main(String[] args) {
		SpringApplication.run(StartupAppSwagger.class, args);
	}

	
}
