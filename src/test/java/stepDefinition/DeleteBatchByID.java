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

public class DeleteBatchByID {
	
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	Response response;
	RequestSpecification request;
	String batchId;
	
	
	@Given("^I ensure to perform POST operation for batch \"([^\"]*)\" with body as$")
    public void I_ensure_to_perform_POST_operation_for_with_body_as(String url, DataTable table) throws Throwable {
		request = RestAssured.given();
	    request.header("Content-Type", "application/json");
	    request.baseUri(BASE_URL);	 
		
		List<List<String>> data = table.asLists(String.class);
    	Map<String, Object>  body = new HashMap<>();
    	body.put("batchName", data.get(1).get(0));
    	body.put("batchDescription", data.get(1).get(1));
    	body.put("batchStatus", data.get(1).get(2));
        body.put("batchNoOfClasses", data.get(1).get(3));
        body.put("programId", data.get(1).get(4));
    	

    	request.body(body);
    	response = request.post(url);
    	batchId = response.getBody().jsonPath().getString("batchId");
	    
	}

	@When("I perform DELETE operation for {string}")
	public void i_perform_DELETE_operation_for(String url) {
		
		 response = request.when().delete(url +"/"+batchId);	
	    
	}
	@Then("I validate delete response code {int}")
	public void i_validate_delete_response_code(int responseCode) {
		int statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode, responseCode);
	   
	    
	
	    
	}


}
