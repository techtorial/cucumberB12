@etsyOutline
Feature: Etsy Search Functionality

  Scenario Outline: Validation title of Etsy Search Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for '<searchItem>'
    Then User sees the title is '<title>'
    Examples:
      | searchItem | title       |
      | Hat        | Hat \| Etsy |
      | Key        | Key \| Etsy |
      | Pin        | Pin \| Etsy |



