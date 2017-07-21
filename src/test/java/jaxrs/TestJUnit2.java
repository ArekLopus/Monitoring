package jaxrs;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

public class TestJUnit2 {
	
	
	private WebTarget target;

	@Before
	public void init() {
		target = ClientBuilder.newClient().target("http://localhost:8080/Monitoring/res/test");
	}
	
	
	@Test
	public void test() {
		String jo = target
				.request(MediaType.TEXT_HTML)
				.get(String.class);
		//System.out.println(jo);
		assertNotNull(jo);
		
	}

}
