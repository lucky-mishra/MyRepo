@ForgetPassword
Feature: Forget Password

  Background:
    Given User is on Login page
    When click on forget password link

  Scenario: Verify back to login navigation
    And click on back to login link
    Then login page should get open

  Scenario: Verify navigation of forget password link
    Then forget password screen should get open


  Scenario Outline: Verify if enter valid username in forget password
    And enter valid "<username>"
    And click on submit button
    Then success message should display
    Examples:
      | username  |
      | subadmin1 |


