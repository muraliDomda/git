//package restAssuredPractice;
//
//import org.junit.Test;
//
//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.internal.http.Method;
//import com.jayway.restassured.response.Response;
//import com.jayway.restassured.specification.RequestSpecification;
//
//public class wetherGetInfoExpale1 {
//
//	Response response;
//
//	@Test
//	public void getExample1() {
//		// RequestSpecification request = RestAssured.given();
//		// Response response = request(Method.GET, "/Hyderabad");
//		//// Response res = req.get();
//		// System.out.println(response.getBody().asString());
//
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
//
//		// Get the RequestSpecification of the request that you want to sent
//		// to the server. The server is specified by the BaseURI that we have
//		// specified in the above step.
//		RequestSpecification httpRequest = RestAssured.given();
//
//		// Make a request to the server by specifying the method Type and the
//		// method URL.
//		// This will return the Response from the server. Store the response in
//		// a variable.
//		response = httpRequest.get();
//		// Now let us print the body of the message to see what response
//		// we have recieved from the server
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body is =>  " + responseBody);
//
//	}
//
//	private Response request(Method get, String string) {
//		System.out.println("++++++" + response.getContentType());
//		return null;
//	}
//
//}
