@search
Feature: Verifying Adactin Hotel Search Hotel details

  Scenario Outline: Verifying search hotel page by selecting all fields
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 05/12/2022  | 06/12/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying search hotel page by selecting mandatory fields
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select only the mantory fields "<Locations>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>" and "<Adultsperroom>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | username  | password       | Locations | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom |
      | Ranjith08 | Sureshdurga96! | London    | 2 - Two   | 05/12/2022  | 06/12/2022   | 2 - Two       |

  Scenario Outline: Verifying search hotel page by invalid date
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the check-in and check-out date error message after search hotel "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 05/12/2023  | 06/12/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying search hotel page by without entering any fields
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should not enter any data and click search button
    Then User should verify the error message after search hotel "Please Select a Location"

    Examples: 
      | username  | password       |
      | Ranjith08 | Sureshdurga96! |
