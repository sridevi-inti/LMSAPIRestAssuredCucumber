package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class PutProgramById {
	
	private static final String BASEURL = "https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	String programId;
	String programName;
	
    @Given("^I ensure to perform POST operation for program \"([^\"]*)\" with body as$")
    public void I_ensure_to_perform_POST_operation_for_with_body_as(String url, DataTable table) throws Throwable {
    	
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
    	
    	Response response = request.post(url);
    	programId = response.getBody().jsonPath().getString("programId");
    	
    }

    @When("^I perform PUT operation for \"([^\"]*)\"$")
    public void I_perform_PUT_operation_for(String url, DataTable table) throws Throwable {
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
    	
    	Response response = request.put(url + "/" + programId);
    	programName = response.getBody().jsonPath().getString("programName");
    	System.out.println("Response status code: " + response.statusCode());
    }

    @Then("^I validate the programName in the body$")
    public void I_validate_the_programName_in_the_body(DataTable table) throws Throwable {
    	List<List<String>> data = table.asLists(String.class);
    	Assert.assertEquals(data.get(1).get(0), programName);
    }

    @Then("^I perform DELETE operation to clear the program for \"([^\"]*)\"$")
    public void I_perform_DELETE_operation_to_clear_the_program_for(String url) throws Throwable {
    	Response response = request.delete(url + "/" + programId);
    	if(response.statusCode() == 200) {
      	  System.out.println("Program id " + programId + " has been deleted successfully.");
        }
    }

}
