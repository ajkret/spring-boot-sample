package br.com.cinq.greet.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.cinq.greet.Application;
import br.com.cinq.greet.bean.Greet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@IntegrationTest("server.port=9000")
@ActiveProfiles("unit")
public class EndpointTest {
	Logger logger = LoggerFactory.getLogger(EndpointTest.class);

	private final String localhost = "http://localhost:";
	
	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();


	@Test
	public void testGet() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Greet> response = this.restTemplate.exchange(
				this.localhost + this.port + "/greet", HttpMethod.GET, entity, Greet.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Greet greet = response.getBody();
		Assert.assertNotNull(greet);
		logger.info("Returned greet " + greet.getMessage());
		Assert.assertNotNull(greet.getMessage());
	}
	
	@Test
	public void testPost() {
		String newMessage = "A wild message appears!";
		
		Greet greet = new Greet();
		greet.setMessage(newMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Greet> entity = new HttpEntity<Greet>(greet, headers);

		ResponseEntity<Void> response = this.restTemplate.exchange(
				this.localhost + this.port + "/greet", HttpMethod.POST, entity, Void.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

		// Check for the change
		headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		ResponseEntity<Greet> result = this.restTemplate.exchange(
				this.localhost + this.port + "/greet", HttpMethod.GET, entity, Greet.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		greet = result.getBody();
		Assert.assertNotNull(greet);
		logger.info("Returned greet " + greet.getMessage());
		Assert.assertEquals(newMessage, greet.getMessage());

	}
}
