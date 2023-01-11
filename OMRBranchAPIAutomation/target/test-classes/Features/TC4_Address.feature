@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add user address to the application through api
    Given User add Header and Bearer authorization for accessing add address endpoint
    When User add request body for add new address "<first_name>", "<last_name>", "<mobile>","<apartment>","<zipcode>","<address>" and "<address_type>"
    And User send "Post" request for addUserAddress endpoint
    Then User verify the status code is 200
    Then User verify the addUserAddress response message matching "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | zipcode | address | address_type |
      | Ranjith    | A S       | 9551885740 | Sri Vaari |  600062 | chennai | home         |

  Scenario Outline: Verify update user address to the application through api
    Given User add Header and Bearer authorization for accessing update address endpoint
    When User add request body for update new address "<address_id>", "<first_name>", "<last_name>", "<mobile>", "<apartment>", "<zipcode>","<address>" and "<address_type>"
    And User send "Put" request for updateUserAddress endpoint
    Then User verify the status code is 200
    Then User verify the updateUserAddress response message matching "Address updated successfully"

    Examples: 
      | address_id | first_name | last_name | mobile     | apartment | zipcode | address | address_type |
      |      39915 | Ranjith    | A S       | 9551885740 | Sri Vaari |  600062 | chennai | home         |

  Scenario Outline: Verify get user address to the application through api
    Given User add Header and Bearer authorization for accessing get address endpoint
    When User send "Get" request for getUserAddress endpoint
    Then User verify the status code is 200
    Then User verify the getUserAddress response message matching "OK"

  Scenario Outline: Verify delete user address to the application through api
    Given User add Header and Bearer authorization for accessing delete address endpoint
    When User add request body for delete address "<address_id>"
    And User send "Delete" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    Then User verify the deleteUserAddress response message matching "Address deleted successfully"

    Examples: 
      | address_id |
      |      39915 |
