package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProgramById {
	private static final String BASEURL = "https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	String programId;
	
	@Given("I perform POST operation for the {string} with body as")
	public void i_perform_post_operation_for_the_with_body_as(String url, DataTable table) {
		  RestAssured.baseURI = BASEURL;
		  request = RestAssured.given();
		List<List<String>> data = table.asLists(String.class);
    	Map<String, Object>  body = new HashMap<>();
    	body.put("programName", data.get(1).get(0));
    	body.put("programDescription", data.get(1).get(1));
    	body.put("programStatus", data.get(1).get(2));

    	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	String stringDate = DateFor.format(new Date());

    	body.put("creationTime", stringDate);
    	body.put("lastModTime", stringDate);
    	
    	request.body(body);
    	response = request.post(url);
    	programId = response.getBody().jsonPath().getString("programId");
	}
	@When("user send the delete request {string}" )
	public void user_send_the_delete_request_deletebyprogid(String url) {
		 response = request.when().delete(url +"/"+programId);	

	}
	@Then("user should get success code {int}")
	public void user_should_get_success_code(int responseCode) {
		int statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode, responseCode);
	}


}
