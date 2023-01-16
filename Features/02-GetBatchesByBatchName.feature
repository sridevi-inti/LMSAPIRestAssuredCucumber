Feature: Test the put  Request for LMSAPI

  Scenario: User successfully get Batch by batch name
	Given User ensure to perform POST operation for "/batches" with body as
    | batchName					| batchDescription 				 		 | batchStatus			| batchNoOfClasses | programId |
  	| bluetooth6514		| Selenium Training New		 		 | Active		    		|	184							 | 1667			 |	
  When User sends the get request with "/batches/batchName" using Batch name as "bluetooth8344"
  Then Status code should be 200 ok
	Then User performs Delete operation to clear the batch for "/batches" 