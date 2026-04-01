Feature: Login Test
Scenario: Open login page

  Given User is on login page
  When User enters email ID and password
  And User clicks on the login button
  Then User should navigate to blind page