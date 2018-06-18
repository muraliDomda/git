package stepDefination;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {

	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "adasdaasdimpleuser2dd2011");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "sample2wewwee26d9@gmail.com");
		request.body(requestParams.toJSONString());
		 Response response = request.post("/register");
	 
		 System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	
}
