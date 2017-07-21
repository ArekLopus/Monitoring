package jaxrs;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("test")
public class Test {
	
	@Context
	HttpHeaders headers;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String testHTML() {
		//headers.getRequestHeaders().values().stream().forEach(e -> System.out.println(e.toString()));
		System.out.println("testHTML() called");
		return "<h2>Hello!</h2>";
	}
	
	@GET
	@Path("{name}")		//path - rest/test/name
	public Response searchUser(@PathParam("name") String name) {
		System.out.println("Got name: "+name);
		return Response.ok(name).build();
	}
	
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response userJSON() {
		return Response.ok(new User("John", "Doe")).build();
	}
}
