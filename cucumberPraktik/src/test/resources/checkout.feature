@checkout
Feature: Checkout

  @positive
  Scenario: Complete checkout process
    Given user have "Sauce Labs Backpack" in cart
    And user input first name with "Tans"
    And user input last name with "Lily"
    And user input postal code with "12345"
    When user click continue button
    When user click finish button
    Then user should see a confirmation message "Thank you for your order!"

  @negative
  Scenario: Checkout with missing information
    Given user have "Sauce Labs Backpack" in cart
    And user input first name with ""
    And user input last name with ""
    And user input postal code with ""
    When user click continue button
    Then user should see an error message

  @boundary
  Scenario: Checkout with short postal code
    Given user have "Sauce Labs Backpack" in cart
    And user input first name with "Tans"
    And user input last name with "Lily"
    And user input postal code with "1"
    When user click continue button
    When user click finish button
    Then user should see a confirmation message "Thank you for your order!"
