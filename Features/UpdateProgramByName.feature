Feature: Test the put  Request for LMSAPI

  Scenario: To Update Program By ProgramName
    Given User is on Put Method with existing ProgramName
    When User sends the put method with updated ProgramName
    Then Status "201" is shown with message "Successfully Updated !!"

  ##Scenario: To update Program By ProgramName with non existing user Id
   ## Given User is on Put Method with non existing ProgramName
    ##When User sends the put method with non existing ProgramName
   ## Then Status "404" is shown with message "Not Found !!"
