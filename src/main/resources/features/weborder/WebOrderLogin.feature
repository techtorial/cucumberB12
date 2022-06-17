Feature: Login Functionality of WebOrder Page

  Scenario: Validation of WebOrder Login Scenario(positive correct username and password)
    Given User navigates to the WebOrder
    When User provides correct 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage



