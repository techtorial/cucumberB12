@product
Feature: Validation of Products

#   Scenario: Validation of New Product Creation
#     Given User navigates to product homepage and clicks Order Button
#     When User enters the product information 'MyMoney' and '4'
#     And User enters the address information 'Ahmet','Midway','Mount Prospect','IL','600056'
#     And User enters the payment information '123456789','12/22','VISA' and process the order
#     Then User validates the message 'New order has been successfully added.'
#     And User clicks View All Orders and validates 'Name','Product','quantity','Street','City','State','Zip','Card','CardNumber','Expiration'


  Scenario Outline: Validation of New Product Creation
    Given User navigates to product homepage and clicks Order Button
    When User enters the product information '<ProductName>' and '<Quantity>'
    And User enters the address information '<CustomerName>','<Street>','<City>','<State>','<ZipCode>'
    And User enters the payment information '<CardNumber>','<ExpireDate>','<CardType>' and process the order
    Then User validates the message '<Message>'
    And User clicks View All Orders and validates 'Name','Product','quantity','Street','City','State','Zip','Card','CardNumber','Expiration'

    Examples:
      | ProductName | Quantity | CustomerName | Street | City           | State | ZipCode | CardNumber | ExpireDate | CardType         | Message                                |
      | MyMoney     | 4        | Ahmet        | Midway | Mount Prospect | IL    | 600056  | 123456789  | 12/22      | VISA             | New order has been successfully added. |
      | FamilyAlbum | 10       | Ahmet        | Midway | Mount Prospect | IL    | 600056  | 123456789  | 12/22      | MasterCard       | New order has been successfully added. |
      | ScreenSaver | 7        | Ahmet        | Midway | Mount Prospect | IL    | 600056  | 123456789  | 12/22      | American Express | New order has been successfully added. |


