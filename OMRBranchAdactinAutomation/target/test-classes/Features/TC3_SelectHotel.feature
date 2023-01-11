Feature: Verifying Adactin Hotel Select Hotel details

  Scenario Outline: Verifying select hotel page by selecting hotel name
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User should select hotel name
    Then User should verify success message after select hotel "Book A Hotel"

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 08/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying select hotel page without selecting hotel name
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User should click continue
    Then User should verify error message after select hotel "Please Select a Hotel"

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 08/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |
