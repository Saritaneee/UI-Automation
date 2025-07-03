@cart
Feature: Cart Functionality

  @positive
  Scenario: Add item to cart
    Given user has logged in
    When user add "Sauce Labs Backpack" to cart
    And user go to the cart
    Then the cart should contain "Sauce Labs Backpack"

  @negative
  Scenario: Remove item from cart
    Given user on the cart page with "Sauce Labs Backpack"
    When user remove "Sauce Labs Backpack" from the cart
    Then the cart should be empty

  @boundary
  Scenario: Add all available products to cart
    Given user has logged in
    When user add all available products to the cart
    And user go to the cart
    Then the cart should contain all added products