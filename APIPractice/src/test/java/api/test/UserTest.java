package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.payloads.User;
import api.payloads.UserEndpoints;
import io.restassured.response.Response;

public class UserTest {
	
	User username;
	@BeforeClass
	public void setUp()
	{
		username = new User();
		username.setId(1);
		username.setJob("IT");
		username.setName("QA");
	}
	
	
	@Test(priority = 1)
	public void postTest()
	{
		Response response=UserEndpoints.createUser(username);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void getTest()
	{
		Response response=UserEndpoints.readUser(this.username.getName());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void deleteTest()
	{
		Response response=UserEndpoints.deleteUser(this.username.getName());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

	
}
