package br.com.cinq.greet.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cinq.greet.bean.Greet;

/**
 * Greet Service
 * 
 * @author Adriano Kretschmer
 */
@Path("/greet")
public class GreetResource {
	Logger logger = LoggerFactory.getLogger(GreetResource.class);

	// For now, store the information on a bean, in memory
	@Autowired
	Greet greet;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response greet() {
		logger.debug("Received GET requisition");
		return Response.ok().entity(greet).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response greet(Greet greet) {
		try {
			this.greet.setMessage(greet.getMessage());
			logger.info("Greeting message updated {}",this.greet.getMessage());
		} catch (Exception e) {
			logger.error("An exception occurred during Greet message update", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("exception").build();
		}

		return Response.ok().build();
	}
}
