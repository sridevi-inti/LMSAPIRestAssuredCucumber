Feature: Feature: To Test the put  Request for LMSAPI

Scenario: Verify PUT operation on program after POST
  Given I perform POST operation for "/saveprogram" with body as
  	| programName | programDescription | programStatus | 
  	| Appium50 | Mobile testing   | Active        |
  When I perform PUT operation for "/putprogram"
  	| programName | programDescription | programStatus | 
  	| Appium55  | Mobile testing   | Active        |
  Then user should get success code 200
 	
  Then I perform clean up by deleting program 
		
	