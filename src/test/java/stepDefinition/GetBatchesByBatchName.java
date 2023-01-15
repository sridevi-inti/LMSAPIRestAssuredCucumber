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

public class GetBatchesByBatchName {
	private static final String BASE_URL="https://lms-backend-service.herokuapp.com/lms";
	RequestSpecification request;
	Response response;
	String jsonString;
	String batchId;
	
	
	

}