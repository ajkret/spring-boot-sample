package br.com.cinq.greet.bean;

import org.springframework.stereotype.Component;

/**
 * POJO used to store information
 * @author Adriano Kretschmer
 */
@Component
public class Greet {
	private String message = "Hello World";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
