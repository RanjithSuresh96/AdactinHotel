@CityId
Feature: City Module API Automation

  Scenario Outline: Verify get City list to the application through api
    Given User add Header for CityList
    When User add request body to get CityList "<state_id>"
    And User send "Post" request for getCityList endpoint
    Then User verify the status code is 200
    Then User verify the CityList response message matching "Thanjavur" and saved City Id

    Examples: 
      | state_id |
      | stateid |
