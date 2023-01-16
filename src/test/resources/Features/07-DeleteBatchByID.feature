@deleteBatchByID
Feature: To delete a batch by ID

  Scenario: To delete a batch by ID
  Given I ensure to perform POST operation for batch "/batches" with body as
  	| batchName       | batchDescription | batchStatus   | batchNoOfClasses | programId |
  	| Java 2000       | Testing          | Active        |  10              | 1972      |
  When I perform DELETE operation for "/batches"
  Then I validate delete response code 200
  








