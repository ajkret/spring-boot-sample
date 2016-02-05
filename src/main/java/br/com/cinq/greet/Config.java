package br.com.cinq.greet;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.greet.bean.NotUsedReferencedConfigurationClass;
import br.com.cinq.greet.resource.GreetResource;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Configuration
@ApplicationPath("/rest")
public class Config extends ResourceConfig {

	public Config() {
		register(GreetResource.class);
		//		packages("br.com.cinq.greet");
		//		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
	
	@Bean
	public NotUsedReferencedConfigurationClass createNotUsedReferencedConfigurationClass() {
		return new NotUsedReferencedConfigurationClass();
	}
	
	/**
	 * Either you use the bean initialization to redirect rest calls or use @ApplicationPath
    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, Config.class.getName());
        return registration;
    }
	 */

}