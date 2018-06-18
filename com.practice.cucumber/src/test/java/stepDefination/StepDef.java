package stepDefination;

import java.util.Map;

import org.junit.Assert;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDef {
	RequestSpecification httpRequest;
	Response response;
	

	@Given("^I set base uri to wether info service$")
	public void i_set_base_uri_to_wether_info_service() throws Throwable {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		httpRequest= RestAssured.given();
	}
			
			
	@When("^I perform get request for \"(.*?)\" end point$")
	public void i_perform_get_request_for_end_point(String arg1) throws Throwable {
		 response = httpRequest.get("/Hyderabad");
		 System.out.println(response.getBody().asString());
	}

	@Then("^the server should handle it and return a success status$")
	public void the_server_should_handle_it_and_return_a_success_status() throws Throwable {
		System.out.println(response.getBody().asString());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
	
	@Then("^I see  response with  success status$")
	public void i_see_response_with_success_status() throws Throwable {
		Assert.assertTrue("expected and actual not matching",response.getStatusCode()==200 );
		System.out.println(response.getContentType());
	}

	@Then("^I see info in below format$")
	public void i_see_info_in_below_format(DataTable responseFields) throws Throwable {
		JsonPath jsonPathEvaluator = response.jsonPath();
		for (Map<String, String> data : responseFields.asMaps(String.class, String.class)) {
			System.out.println(data.get("keyvalue"));
			System.out.println(jsonPathEvaluator.get(data.get("keyname")).toString());
			
		Assert.assertTrue("expected and actual not matching", jsonPathEvaluator.get(data.get("keyname")).toString().equals(data.get("keyvalue")));
		}
	}
}