package jaxrs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

public class TestJUnit {
	
	
	private WebTarget target;


	@Before
	public void init() {
		target = ClientBuilder.newClient().target("http://localhost:4848/monitoring/domain/server/applications/Monitoring/Test.json");
	}
	
	
	@Test
	public void test() {
		JsonObject jo = target
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic YWRtaW46YWRtaW4=")	//encoded b64 - admin:admin
				.get(JsonObject.class);
		//System.out.println(jo);
		//assertNull(jo);
		assertNotNull(jo.getJsonObject("extraProperties"));
		
	}

}
