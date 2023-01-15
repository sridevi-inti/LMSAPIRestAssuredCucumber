$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/GetAllPrograms.feature");
formatter.feature({
  "name": "Test the Get Request for LMSAPI",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The user makes a successful Get request",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on Get Method to get all programs",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.GetAllPrograms.user_is_on_get_method_to_get_all_programs()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sends the get method with endpoints Allprograms",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.GetAllPrograms.user_sends_the_get_method_with_endpoints_allprograms()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user should get a successful response code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.GetAllPrograms.the_user_should_get_a_successful_response_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:Features/GetBatchesByBatchName.feature");
formatter.feature({
  "name": "Test the put  Request for LMSAPI",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User successfully get Batch by batch name",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User ensure to perform POST operation for \"/batches\" with body as",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.user_ensure_to_perform_post_operation_for_with_body_as(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sends the get request using Batch name as \"bluetooth8344\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.user_sends_the_get_request_using_Batch_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code should be 200 ok",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.status_code_should_be_ok(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:Features/UpdateBatchById.feature");
formatter.feature({
  "name": "Test the put  Request for LMSAPI",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User successfully updates Batch by ID",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User ensure to perform POST operation for \"/batches\" with body as",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.user_ensure_to_perform_post_operation_for_with_body_as(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sends the put request using updated Batch ID for \"/batches\" with body as",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.user_sends_the_put_request_using_updated_batch_id_with_body_as(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code should be 200 ok",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.status_code_should_be_ok(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User performs Delete operation to clear the batch for \"/batches\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.UpdateBatchById.user_performs_delete_operation_to_clear_the_batch_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:Features/UpdateProgramByName.feature");
formatter.feature({
  "name": "Test the put  Request for LMSAPI",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To Update Program By ProgramName",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on Put Method with existing ProgramName",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.updateProgramByName.user_is_on_put_method_with_existing_program_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sends the put method with updated ProgramName",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.updateProgramByName.user_sends_the_put_method_with_updated_program_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status \"201\" is shown with message \"Successfully Updated !!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.updateProgramByName.status_is_shown_with_message(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});