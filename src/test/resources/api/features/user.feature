@api
Feature: CRM User API

# ✅ 1. GET LIST (positive)
  Scenario: Get list user
    Given User set GET endpoint
    When User send GET request
    Then Response status should be 200

# ✅ 2. GET INVALID (negative)
  Scenario: Get user with invalid ID
    Given User set GET endpoint
    When User send invalid GET request
    Then Response status should be 404

# ✅ 3. CREATE USER (positive)
  Scenario: Create new user successfully
    Given user set base api url
    When user create new user
    Then response should be success

# ✅ 4. GET USER BY ID (chained test)
  Scenario: Get user by id
    Given user set base api url
    When user create new user
    And user get user by id
    Then response should be success

# ✅ 5. CREATE USER WITHOUT EMAIL (negative 🔥)
  Scenario: Create user without email should fail
    Given user set base api url
    When user create user without email
    Then response should be error