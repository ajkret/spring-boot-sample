package br.com.cinq.greet.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * POJO used to test a spring feature. It has a reference on a @Configuration annotated class.
 * @author Adriano Kretschmer
 */
@Component
public class NotUsed {
	static Logger logger = LoggerFactory.getLogger(NotUsed.class);

	private String message = "Hello World";

	public NotUsed() {
		logger.debug("This class wansn't supposed to be initialized");
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
