package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class UpdateBatchById {
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	String jsonString;
	String batchId;


@Given("User ensure to perform POST operation for \"([^\"]*)\" with body as$")
public void user_ensure_to_perform_post_operation_for_with_body_as(String url, DataTable table) throws Throwable {
	List<List<String>> data = table.asLists(String.class);
	Map<String, Object>  body = new HashMap<>();
	body.put("batchName", data.get(1).get(0).toString());
	body.put("batchDescription", data.get(1).get(1));
	body.put("batchStatus", data.get(1).get(2));
	body.put("batchNoOfClasses", data.get(1).get(3));
	body.put("programId", data.get(1).get(4));

	JSONObject jsonbody = new JSONObject(body);
	
	//System.out.println("POST Request body: " + jsonbody.toString());
	
	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	String stringDate = DateFor.format(new Date());
	
	body.put("creationTime", stringDate); 
	body.put("lastModTime", stringDate);

	request = RestAssured.given();
	request.header("Content-Type", "application/json");
	request.header("Accept", "*/*");
	request.body(jsonbody.toString());
	request.baseUri(BASE_URL);

//	System.out.println("POST Response url: " + BASE_URL+url);
	Response response = request.post(url);
	System.out.println("POST Response status code: " + response.statusCode());
	System.out.println("POST Response: " + response.getBody().asPrettyString());
	batchId = response.getBody().jsonPath().getString("batchId");
	System.out.println("POST Response batchId: " + batchId);
//	response = request.when().put("/(BatchId)");

}


@When("User sends the put request using updated Batch ID for \"([^\"]*)\" with body as$") 
public void user_sends_the_put_request_using_updated_batch_id_with_body_as(String url, DataTable table) throws Throwable {
	List<List<String>> data = table.asLists(String.class);
	Map<String, Object>  body = new HashMap<>();
	body.put("batchName", data.get(1).get(0));
	body.put("batchDescription", data.get(1).get(1));
	body.put("batchStatus", data.get(1).get(2));
	body.put("batchNoOfClasses", data.get(1).get(3));
	body.put("programId", data.get(1).get(4));
	body.put("programName", data.get(1).get(5));

	JSONObject jsonbody = new JSONObject(body);
	
	SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	String stringDate = DateFor.format(new Date());
	body.put("lastModTime", stringDate);
	body.put("creationTime", stringDate);

	request.header("Content-Type", "application/json");
	request.header("Accept", "*/*");
	request.body(jsonbody.toString());
	request.baseUri(BASE_URL);

	response = request.put(url + "/" + batchId);
	//batchId = response.getBody().jsonPath().getString("BatchId");
	//System.out.println("PUT Response status code: " + response.statusCode());
	//System.out.println("PUT Response: " + response.getBody().asPrettyString());
	
}

@When("User sends the get request with {string} using Batch name as {string}")
public void user_sends_the_get_request_using_Batch_name(String url, String batchName) {
	response = request.when().get(url + "/" + batchName);
}

	
@Then("Status code should be {int} ok")
public void status_code_should_be_ok(Integer int1) {
	//@SuppressWarnings("unchecked")
	int statusCode=((ResponseOptions<Response>) response).getStatusCode();
     Assert.assertEquals(200, statusCode);
}

@Then("^User performs Delete operation to clear the batch for \"([^\"]*)\"$")
public void user_performs_delete_operation_to_clear_the_batch_for(String url) {
    
	Response response = request.delete(url + "/" + batchId);
	//System.out.println("DELETE Response status code: " + response.statusCode());
	//System.out.println("DELETE Response: " + response.getBody().asPrettyString());
	if(response.statusCode() == 200) {
  	  System.out.println("Batch id " + batchId + " has been deleted successfully.");
}

}
}