package com.andres.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({// configuración para varios properties
	@PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),// configuración para otra properties más

})
public class ValuesConfig {

}
