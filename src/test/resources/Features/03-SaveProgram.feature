Feature: Test the put  Request for LMSAPI

  Scenario: To Save Program By ProgramName
    Given User ensures to perform POST operation with body like
  	| programName  | programDescription | programStatus | 
  	| PostgreSQL3365 | Learn PostgreSql14 | Active        |
    When User sends the post request using the "/saveprogram" as 
    Then User validates status code as 201 ok
    Then User performs Delete operation to clear porgram for the url "/deletebyprogid" 
