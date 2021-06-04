@Login
Feature: Login

  Background:
    Given User is on home page

  Scenario Outline: Verify login with valid credentials
    When click on signin link
    Then login page should get open
    And enter username as "<username>"
    And enter password as "<password>"
    And click signin button
    Then verify that user got logged in
    Examples:
      | username                   | password |
      | lucky1985.mayank@gmail.com | mayank24 |