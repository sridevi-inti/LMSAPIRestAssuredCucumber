
Feature: To Delete a  program  by ID
  
  Scenario: To Delete by program ID
    Given User perform POST operation for the "/saveprogram" with body as
  	| programName | programDescription | programStatus | 
  	| Appium62 | Mobile testing   | Active        |
    When user send the delete request "/deletebyprogid"
   Then user should get success code 200
    