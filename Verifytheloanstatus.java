package UiBank;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Verifytheloanstatus {

	
	@Test
	public void verifytheloanstatus() {
		
		
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/quotes/5fd0ea9f277e35002d760119";
		
		
		
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
				
				.get();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
				JsonPath jsonResponse = response.jsonPath();
				
				String id = jsonResponse.getString("id");
				System.out.println(id);
					
				
				
	}
	

}
