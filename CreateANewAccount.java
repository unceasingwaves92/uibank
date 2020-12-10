package UiBank;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateANewAccount {
	
	
	@Test
	public void createANewAccount() {
		
		
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/accounts";
		
		
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(
			              "Authorization",
			              "XtyM7CuLvtBQ1lQxSgXAzRmFUYStZFt0XIMDC8HREEQwKp7zolcdMNtfnpADxJB3",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
				.body("{\"friendlyName\" : \"Karthikeyan\",\"type\" : \"savings\",\"userId\" : \"5fd0e260277e35002d76010d\",\"balance\" : \"100\",\"accountNumber\" :\"40525164\"}")
				.post();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
				JsonPath jsonResponse = response.jsonPath();
				
				String id = jsonResponse.getString("id");
				System.out.println(id);
					
				
				
	}
	

}
