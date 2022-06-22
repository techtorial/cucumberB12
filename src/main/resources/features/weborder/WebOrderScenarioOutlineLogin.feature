Feature: WebOrder Login functionality with Scenario Outline

  Background:
    Given User navigates to the WebOrder

  Scenario: Validation of WebOrder positive Login Scenario
    When User provides credentials 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage

  Scenario Outline: Validation of WebOrder  negative Login Scenarios
    When User provides credentials '<username>' and '<password>' for WebOrder
    Then User validates the '<message>' error message.
    Examples:
      | username              | password    | message        |
      | ahmet@gmail.com       | Guest1!      | Sign in Failed |
      | guest1@microworks.com | sdgf         | Sign in Failed |
      |                       |              | Sign in Failed |
      | 1434sdfsdg@gmail.com  | $#$&$#^*$&^# | Sign in Failed |
      |                       | &$#&$&       | Sign in Failed |




  #convert this format into scenario outline.And do 9 different negative scenarios
