@ProfilePic
Feature: Profile Picture Module API Automation

  Scenario: Verify update profile picture in the application through api
    Given User add Header and Bearer authorization for accessing profile picture endpoint
    When User add request body to profile picture
    And User send "Post" request for profile picture endpoint
    Then User verify the status code is 200
    Then User verify the profile Picture response message matching "Profile updated Successfully"
