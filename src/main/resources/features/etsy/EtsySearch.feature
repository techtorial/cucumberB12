@etsy
Feature: Etsy Search Functionality

  Scenario: Validation title of Etsy Search Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Hat'
    Then User sees the title is 'Hat | Etsy'

  Scenario: Validation title of Etsy Search Key
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Key'
    Then User sees the title is 'Key | Etsy'

  Scenario: Validation title of Etsy Search Pin
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Pin'
    Then User sees the title is 'Pin | Etsy'




