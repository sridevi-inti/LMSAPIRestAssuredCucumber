Feature: Feature: To Test the put  Request for LMSAPI

Scenario: Verify the PUT operation on program after POST
  Given User perform POST operation for "/saveprogram" with body as
  	| programName | programDescription | programStatus | 
  	| Appium50 | Mobile testing   | Active        |
  When User perform PUT operation for "/putprogram"
  	| programName | programDescription | programStatus | 
  	| Appium55  | Mobile testing   | Active        |
  Then User should get success code as 200
 	
  Then User perform clean up by deleting program 
		
	