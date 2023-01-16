package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class GetProgramByID {
	
  private static final String BASEURL = "https://lms-backend-service.herokuapp.com/lms";	
  Response response;
  RequestSpecification request;
	
  @Given("A Service with the {string}")
  public void A_Service_with_the(String url) {
	  RestAssured.baseURI = BASEURL;
	  request = RestAssured.given();
	  
  }

  @When("user sends get request")
  public void user_sends_get_request(){
	  response = request.get("/programs/367");
  }

  @Then("user should get successful response code {int}")
  public void user_should_get_successful_response_code(int responseCode){
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, responseCode);
	  
  }

}
