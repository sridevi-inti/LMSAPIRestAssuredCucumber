@GetAllPrograms
Feature: To view the restful All Programs

  Scenario: To get all the programs details
    Given a service with "https://lms-backend-service.herokuapp.com/lms/allPrograms"
    When user sends request to get the program details
    Then user should get the response code 200
