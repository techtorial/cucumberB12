Feature: WebOrder page Food Order Functionality

  # Navigate to the website and login successfully
  #Validate the ORDER DETAILS from order page
  #Click Group Order box and Click Next button
  #Choose my location is My House
  #Validate the adress contains 1854 Empire Blvd
  #Send the word for Note to Invitees part
  #send two gmail for Invite List
  #Click Create Group Order
  #Validate View Group Order header
  #Validate total participant is 1

  Scenario: Testing the webOrder functionality
    Given User navigates to the WebOrder
    And  User provides credentials 'guest1@microworks.com' and 'Guest1!' for WebOrder
    When User validates the 'ORDER DETAILS - Weborder' from homepage
    And Use clicks Group Order Box and Next Button










