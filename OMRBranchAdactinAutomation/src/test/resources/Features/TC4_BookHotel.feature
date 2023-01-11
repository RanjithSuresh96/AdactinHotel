Feature: Verifying Adactin Hotel Book Hotel details

  Scenario Outline: Verifying book hotel page by selecting all fields
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

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom | FirstName | LastName | BillingAddress |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 08/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          | Sam       | kumar    | Thoothukudi    |

  Scenario Outline: Verifying book hotel page by without entering any fields
    Given User is on the Adactin login page
    When User should perform login "<username>","<password>"
    Then User should verify the success message after login "Hello Ranjith08!"
    When User should select all fields "<Locations>","<Hotels>","<RoomType>","<NoOfRooms>","<CheckinDate>","<CheckoutDate>","<Adultsperroom>" and "<Childrensperroom>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User should select hotel name
    Then User should verify success message after select hotel "Book A Hotel"
    When User should not enter any fields and click book now button
    Then User should verify error message after book hotel "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username  | password       | Locations | Hotels        | RoomType | NoOfRooms | CheckinDate | CheckoutDate | Adultsperroom | Childrensperroom |
      | Ranjith08 | Sureshdurga96! | London    | Hotel Cornice | Deluxe   | 2 - Two   | 08/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |
