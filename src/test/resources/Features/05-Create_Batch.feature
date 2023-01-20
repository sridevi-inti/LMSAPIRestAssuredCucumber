Feature: Test the Create Request for LMSAPI

  Scenario: To Create new batch
    Given User ensures to perform POST operation with the body as
  	| batchName | batchDescription | batchStatus |batchNoOfClasses | programId |
		|Jan23-ApiNinja-SDET-016|Team-16 |Active |7 |1340 |
    When User sends post request using "/batches" as 
    Then Status code should come 201 ok
    Then User performs Delete to clear the porgram for the url "/batches" 