@web
Feature: Demoblaze Login

  Scenario: Successful login
    Given User is on login page
    When User input valid username and password
    Then User should be redirected to dashboard

  Scenario: Invalid login
    Given User is on login page
    When User input invalid username and password
    Then Error message should be displayed