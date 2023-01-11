@login
Feature: Verifying Adactin Hotel Login details

  Background: 
    Given User is on the Adactin login page

  Scenario Outline: Verifying Adactin Hotel login using valid details
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"

    Examples: 
      | username  | password       |
      | Ranjith08 | Sureshdurga96! |

  Scenario Outline: Verifying Adactin Hotel login using valid details and perform Enter key
    When User should perform login "<username>","<password>" and perform Enter key
    Then User should verify the success message after login "Hello Ranjith08!"

    Examples: 
      | username  | password       |
      | Ranjith08 | Sureshdurga96! |

  Scenario Outline: Verifying Adactin Hotel login using Invalid details
    When User should perform login "<username>","<password>"
    Then User should verify the Invalid credentials error message after login which contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | username | password    |
      | Ranji87  | Sureshdur76 |
