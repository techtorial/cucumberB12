Feature: Login Functionality of WebOrder Page

  Background:
    Given User navigates to the WebOrder

  Scenario: Validation of WebOrder Login Scenario(correct username and password)
    #Given User navigates to the WebOrder
    When User provides credentials 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage

  Scenario: Validation of WebOrder Login Scenario(correct username and wrong password)
    #Given User navigates to the WebOrder
    When User provides credentials 'guest1@microworks.com' and 'ahmet' for WebOrder
    Then User validates the 'Sign in Failed' error message.

  Scenario: Validation of WebOrder Login Scenario(wrong username and correct password)
   # Given User navigates to the WebOrder
    When User provides credentials 'ahmet@gmail.com' and 'Guest1!' for WebOrder
    Then User validates the 'Sign in Failed' error message.

  Scenario: Validation of WebOrder Login Scenario(empty username and empty password)
    #Given User navigates to the WebOrder
    When User provides credentials '' and '' for WebOrder
    Then User validates the 'Sign in Failed' error message.