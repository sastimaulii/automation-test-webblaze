Feature: End to End DemoBlaze

  @e2e-positive
  Scenario: Login success
    Given User is on homepage
    When User click login button
    And User input valid credentials
    Then User should be logged in

    When User add product "Samsung galaxy s6" to cart
    And User go to cart page
    Then Product should be displayed in cart

    When User click logout button
    Then User should be logged out


  @e2e-negative
  Scenario: Failed login with invalid credentials
    Given User is on homepage
    When User click login button
    And User input invalid credentials
    Then System should show login error