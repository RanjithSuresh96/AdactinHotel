@SearchProduct
Feature: Search Product Module API Automation

  Scenario Outline: Verify search product in the application through api
    Given User add Header and Bearer authorization for accessing search product endpoint
    When User add request body to search product "<productname>"
    And User send "Post" request for search product endpoint
    Then User verify the status code is 200
    Then User verify the search product response message matching "OK"

    Examples: 
      | productname |
      | nuts        |
