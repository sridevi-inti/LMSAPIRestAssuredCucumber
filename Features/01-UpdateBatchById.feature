Feature: Test the put  Request for LMSAPI

  Scenario: User successfully updates Batch by ID
    Given User ensure to perform POST operation for "/batches" with body as
    | batchName					| batchDescription 				 		 | batchStatus			| batchNoOfClasses | programId |
  	| bluetooth6714		| Selenium Training New		 		 | Active		    		|	184							 | 1667			 |
    When User sends the put request using updated Batch ID for "/batches" with body as
    | batchName											  | batchDescription | batchStatus			| batchNoOfClasses | programId | programName 				|
  	| Batch Description2 changed  		| Java Test			   | Active		        | 15				        |	1667			| Program-202304212939|
    Then Status code should be 200 ok
    Then User performs Delete operation to clear the batch for "/batches" 

