package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBatchesByProgramId {
	public static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	 RequestSpecification request;
	Response response;
	
	@Given("A Service with {string}")
	public void a_service_with(String string) {
		RestAssured.baseURI=BASE_URL;
		request =RestAssured.given();
		request.header("Content-Type","application/json");
	    
	}

	@When("user sends get request with Program ID")
	public void user_sends_get_request_with_program_id() {
		response = request.get("/batches/program/221");
	}

	@Then("user can get successful response code {int}")
	public void user_can_get_successful_response_code(Integer int1) {
		int statusCode= response.getStatusCode();
	     Assert.assertEquals(statusCode, 200);
	}



}
