package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class GetAllPrograms {
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	private static Response response;
	private static String jsonString;
	

	
	@Given("User is on Get Method to get all programs")
	public void user_is_on_get_method_to_get_all_programs() {
		
		RestAssured.baseURI=BASE_URL;
		request =RestAssured.given();
		request.header("Content-Type","application/json");
	}

	@When("User sends the get method with endpoints Allprograms")
	public void user_sends_the_get_method_with_endpoints_allprograms() {
		response = request.when().get("/allPrograms");
	    
	}

	@Then("The user should get a successful response code {int}")
	public void the_user_should_get_a_successful_response_code(Integer int1) {
		@SuppressWarnings("unchecked")
		int statusCode=((ResponseOptions<Response>) response).getStatusCode();
	     Assert.assertEquals(statusCode, 200);
	    
	}
}
