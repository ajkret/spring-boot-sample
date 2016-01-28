package br.com.cinq.greet;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.cinq.greet.resource.GreetResource;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Component
@ApplicationPath("/rest")
public class Config extends ResourceConfig {

	public Config() {
		register(GreetResource.class);
		//		packages("br.com.cinq.greet");
		//		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}