package monitoring;

import java.util.Map;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {

	public RestClient() {
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:4848/monitoring/domain/server/applications/WebApp/Test.json");
		
		JsonObject jo = webTarget
			.request(MediaType.APPLICATION_JSON)
			.header("Authorization", "Basic YWRtaW46YWRtaW4=")	//encoded b64 - admin:admin
			.get(JsonObject.class);
		
		//System.out.println(jo);
		
		Map<String, JsonValue> map = jo;
		//System.out.println(map.keySet());
		//System.out.println(map.get("extraProperties"));
		//Map<String, JsonValue> map2 = (Map<String, JsonValue>) map.get("extraProperties");
		//System.out.println(map2.keySet());
		
		
		JsonObject props = jo.getJsonObject("extraProperties");
        JsonObject entity = props.getJsonObject("entity");
        JsonObject cc = entity.getJsonObject("createcount");
        //int count = cc.getInt("count");
        //JsonNumber count = cc.getJsonNumber("count");
        JsonValue count = cc.get("count");
        System.out.println(cc);
        System.out.println(count);
		
		
		client.close();
	}
	
	
	public static void main(String... args) {
		new RestClient();
	}
}
