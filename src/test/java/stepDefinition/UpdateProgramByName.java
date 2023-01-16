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
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class UpdateProgramByName {
	
	private static final String BASEURL = "https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	  Response response;

	int programId;
	String programName;
	@Given("User perform POST operation for {string} with body as")
	public void User_perform_post_operation_for_with_body_as(String url, DataTable table) {
		List<List<String>> data = table.asLists(String.class);
    	Map<String, Object>  body = new HashMap<>();
    	body.put("programName", data.get(1).get(0));
    	body.put("programDescription", data.get(1).get(1));
    	body.put("programStatus", data.get(1).get(2));

    	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	String stringDate = DateFor.format(new Date());

    	body.put("creationTime", stringDate);
    	body.put("lastModTime", stringDate);
    	
    	request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	request.body(body);
    	request.baseUri(BASEURL);
    	
    	response = request.post(url);
    	programId = response.getBody().jsonPath().getInt("programId");
	    
	}
	@When("User perform PUT operation for {string}")
	public void User_perform_PUT_operation_for(String url, DataTable table) {
		List<List<String>> data = table.asLists(String.class);
    	Map<String, Object>  body = new HashMap<>();
    	body.put("programName", data.get(1).get(0));
    	body.put("programDescription", data.get(1).get(1));
    	body.put("programStatus", data.get(1).get(2));

    	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	String stringDate = DateFor.format(new Date());
    	body.put("lastModTime", stringDate);
    	body.put("creationTime", stringDate);
    	
    	request.header("Content-Type", "application/json");
    	request.body(body);
    	request.baseUri(BASEURL);
    	
    	response = request.put(url + "/" + programId);
    	programName = response.getBody().jsonPath().getString("programName");
    	System.out.println("Response status code: " + response.statusCode());

	}
	@Then("User should get success code as {int}")
	public void User_should_get_success_code_as(int responseCode) {
		int statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode, responseCode);
		  
	}


	@Then("User perform clean up by deleting program")
	public void User_perform_clean_up_by_deleting_program(){
		Response response = request.delete(BASEURL + "/deletebyprogid/" + programId);
	
		if(response.statusCode() == 200) {
	  	  System.out.println("Program id " + programId + " has been deleted successfully.");
	}
	    
	}
}
