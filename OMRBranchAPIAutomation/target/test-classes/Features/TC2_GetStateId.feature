@StateId
Feature: State Module API Automation

  Scenario: Verify get state list to the application through api
    Given User add Header for StateList
    When User send "Get" request to getStateList endpoint
    Then User verify the status code is 200
    Then User verify the StateList response message matching "Tamil Nadu" and saved State Id
