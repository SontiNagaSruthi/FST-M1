@activity1
  Feature: First Test

    Scenario: Opening a webpage using Selenium
      Given User is on the google home page
      When  User types in cheese and hit enter
      Then  Show how many test results are generated
      And   Close the browser