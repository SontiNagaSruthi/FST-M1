@activity4
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given user is on Login page
    When user enters "admin" and "password"
    Then read the page title and confirmation message
    And close the Browser