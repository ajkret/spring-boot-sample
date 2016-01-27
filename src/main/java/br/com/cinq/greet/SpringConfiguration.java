package br.com.cinq.greet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.greet.bean.NotUsedReferencedConfigurationClass;

/**
 * Configuration is optional on Spring. But it is a great way to manually initialize beans.
 */
@Configuration
public class SpringConfiguration {
	
	@Bean
	public NotUsedReferencedConfigurationClass createNotUsedReferencedConfigurationClass() {
		return new NotUsedReferencedConfigurationClass();
	}

}
