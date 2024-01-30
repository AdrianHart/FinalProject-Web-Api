@web
Feature: Automation WEB Demoblaze

  # POSITIVE WEB TEST
  @cart-positive-web
  Scenario: User want to add item to cart
    Given user is on home page
    When user click add to cart button for this product:
      | Samsung galaxy s6 |
    And user go to the cart page
    And the cart should be contain:
      | Samsung galaxy s6 |
    Then the total price is correct

  @cart-positive-web
  Scenario: User want to add item 2 times to cart
    Given user is on home page
    When user click add to cart button for this product 2 times:
      | Samsung galaxy s6 |
    And user go to the cart page
    And the cart should be contain 2 items:
      | Samsung galaxy s6 |
    Then the total price is correct

  @cart-positive-web
  Scenario: User want return to homepage from cart with Product Store logo
    Given user is on home page
    And user go to the cart page
    And user click Product Store on top left
    Then user will be directed to home page

  @cart-positive-web
  Scenario: User want to delete item from cart
    Given user is on home page
    When user click add to cart button for this product:
      | Samsung galaxy s6 |
    And user go to the cart page
    And the cart should be contain:
      | Samsung galaxy s6 |
    Then the total price is correct
    Then user remove item from cart
