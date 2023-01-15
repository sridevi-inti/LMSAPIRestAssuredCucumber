Feature: Test the Get Request for LMSAPI

  Scenario: The user makes a successful Get request
    Given User is on Get Method to get all programs
    When User sends the get method with endpoints Allprograms
    Then The user should get a successful response code 200