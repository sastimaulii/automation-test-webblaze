@e2e
Feature: End to End DemoBlaze

  @e2e-positive
  Scenario: Login success
    Given User is on homepage
    When User click login button
    And User input valid credentials
    Then User should be logged in

    When User select product "Samsung galaxy s6"
And User click Add to cart
Then Product should be added to cart

    When User click logout button
    Then User should be logged out


  @e2e-negative
  Scenario: Failed login with invalid credentials
    Given User is on homepage
    When User click login button
    And User input invalid credentials
    Then System should show login error
