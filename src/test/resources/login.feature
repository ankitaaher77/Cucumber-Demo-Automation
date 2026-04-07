Feature: Login Test
  Scenario Outline: Login Test

  Given User is on login page
  When User enters "<email>" and "<password>"
  And User clicks on the login button
    Then User should navigate to Users page

  Examples:
    | email             | password  |
    | biba@yopmail.com | Test@123  |
    | vela@yopmail.com | Test@123  |
    | vela101@yopmail.com | Test@1234  |