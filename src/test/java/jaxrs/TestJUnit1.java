package jaxrs;

import static org.junit.Assert.assertNotNull;

import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

public class TestJUnit1 {
	
	
	private WebTarget target;


	@Before
	public void init() {
		target = ClientBuilder.newClient().target("http://localhost:8080/Monitoring/res/test/json");
	}
	
	
	@Test
	public void test() {
		JsonObject jo = target
				.request(MediaType.APPLICATION_JSON)
				.get(JsonObject.class);
		//System.out.println(jo);
		assertNotNull(jo);
		
	}

}
