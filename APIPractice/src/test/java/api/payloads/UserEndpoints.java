package api.payloads;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api.endpoints.routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	@Test
	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(routes.post_URL);
		
		return response;		
	}
	

	@Test
	public static Response readUser(String username)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		
		.when()
		.get(routes.get_URL);
		
		return response;		
	}
	
	@Test
	public static Response updateUser(String username,User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		
		.when()
		.post(routes.post_URL);
		
		return response;		
	}
	
	@Test
	public static Response deleteUser(String username)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		
		.when()
		.delete(routes.post_URL);
		
		return response;		
	}

}
