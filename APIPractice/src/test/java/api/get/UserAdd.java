package api.get;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;


public class UserAdd {
	
	@Test
	
	void addUser()
	{
	 HashMap data = new HashMap();
	 data.put("name", "Scot");
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().headers();
	}



}
