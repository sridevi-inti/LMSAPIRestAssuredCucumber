Feature: Update program by id
  Test the update operation

@tag2
Scenario: Verify PUT operation on program after POST
  Given I ensure to perform POST operation for program "/saveprogram" with body as
  	| programName | programDescription | programStatus | 
  	| Cucumber 75 | Cucumber testing   | Active        |
  When I perform PUT operation for "/putprogram"
  	| programName | programDescription | programStatus | 
  	| Cucumber 82 | Cucumber testing   | Active        |
  Then I validate the programName in the body
		| programName |
		| Cucumber 82 |
	Then I perform DELETE operation to clear the program for "/deletebyprogid"