@cancel
Feature: Verifying Adactin Hotel Booked Itinerary details

  Scenario Outline: Verifying Booked Itinerary page by cancelling generated order id
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User should select hotel name
    Then User should verify success message after select hotel "Book A Hotel"
    When User should book hotel "<FirstName>","<LastName>" and "<BillingAddress>"
      | CreditCardNo     | CreditCardType   | SelectMonth | SelectYear | CVV  |
      | 9876543234567898 | Master Card      | May         |       2017 | 5434 |
      | 6723646247263744 | VISA             | October     |       2018 |  434 |
      | 2349249827947283 | American Express | June        |       2012 | 6533 |
      | 2492734928942346 | Other            | July        |       2022 | 6534 |
    Then User should verify success message after book hotel "Booking Confirmation" and save the generated order id
    Then User should verify success message after cancel generated order id "The booking has been cancelled."

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom | FirstName | LastName | BillingAddress |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 08/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          | Sam       | kumar    | Thoothukudi    |

  Scenario Outline: Verifying Booked Itinerary page by cancelling existing order id
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should cancel existing order id "<orderid>"
    Then User should verify success message after cancel existing order id "The booking has been cancelled."

    Examples: 
      | username  | password       | orderid    |
      | Ranjith08 | Sureshdurga96! | RN1FI9RLO2 |
