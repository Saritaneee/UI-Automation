@login
Feature: Login

  @positive
  Scenario: login using valid username and password
    Given user on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user on homepage

    @negative
  Scenario: login using invalid username and password
    Given user on login page
    And user input username with "standard_user"
    And user input password with "invalid"
    When user click login button
    Then user able to see error message