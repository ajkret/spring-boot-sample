package br.com.cinq.greet;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Service;

import br.com.cinq.greet.resource.GreetResource;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Service
public class Config extends ResourceConfig {

	public Config() {
		register(GreetResource.class);
	}
}