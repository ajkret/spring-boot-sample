package br.com.cinq.greet.bean;

import org.springframework.stereotype.Component;

/**
 * POJO used to test a spring feature. It has a reference on a @Configuration annotated class.
 * @author Adriano Kretschmer
 */
@Component
public class NotUsedReferencedConfigurationClass {
	private String message = "Hello World";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
