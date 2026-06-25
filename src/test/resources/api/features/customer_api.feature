@api
Feature: Customer API Testing

  Background:
    Given API base url is set

  @positive
  Scenario: Create customer with valid data
    When I send POST request to "/api/customers" with valid payload
    Then response status should be 201
    And response body should contain "name" as "John Doe"

  @negative
  Scenario: Create customer with invalid data
    When I send POST request to "/api/customers" with invalid payload
    Then response status should be 400

  @unauthorized
  Scenario: Create customer without token
    When I send POST request to "/api/customers" without authorization
    Then response status should be 401