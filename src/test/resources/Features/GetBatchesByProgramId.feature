Feature: Test the Get Request for LMSAPI
Scenario: Get batches by Program Id
  Given A Service with "https://lms-backend-service.herokuapp.com/lms/batches/program/221"
  When user sends get request with Program ID
  Then user can get successful response code 200
