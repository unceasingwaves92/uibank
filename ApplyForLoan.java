package UiBank;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApplyForLoan {
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		
		String[] data = new String[1];
		data[0] = "./data/uibank.json";
		
		return data;
	}
	
	
	@Test(dataProvider = "fetchData")
	public void applyForLoan(String filePath) {
		
		
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/quotes/newquote";
		
		
		File file = new File(filePath);
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
				.body(file)
				.post();
				
				response.prettyPrint();
				System.out.println(response.getStatusCode());
				
				JsonPath jsonResponse = response.jsonPath();
				
				String quoteId = jsonResponse.getString("quoteid");
				System.out.println(quoteId);
					
				
				
	}
	

}
