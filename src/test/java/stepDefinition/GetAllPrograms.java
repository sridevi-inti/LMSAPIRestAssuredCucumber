package stepDefinition;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.LogManager;

import org.junit.Assert;
import org.junit.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.Scenario;




public class GetAllPrograms {
	
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	Response response;
	RequestSpecification request;
	
	
	@Given("a service with {string}")
	public void a_service_with(String string) {
		 RestAssured.baseURI = BASE_URL;
		  request = RestAssured.given();
		 RestAssured.baseURI=BASE_URL;
		
			request.header("Content-Type","application/json");

	}
	
	@When("user sends request to get the program details")
	public void user_sends_request_to_get_the_program_details() {
		 response = request.get("/allPrograms");
		    
		}
	    
	@Then("user should get the response code {int}")
	public void user_should_get_the_response_code(int responseCode) {
		int statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode, responseCode);
	   

		
	}

	



}
