package br.com.cinq.greet;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Service;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Service
public class Config extends ResourceConfig {

	public Config() {
		packages("br.com.cinq.greet");
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}