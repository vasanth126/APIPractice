package api.get;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UserGet {
	
	@Test
	
	void getUser() 
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}

}
