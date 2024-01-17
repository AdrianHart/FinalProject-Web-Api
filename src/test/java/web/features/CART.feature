Feature: Automation WEB Demoblaze

  # POSITIVE API TEST
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
    And the cart should be contain:
      | Samsung galaxy s6 |
    Then the total price is correct

  @cart-positive-web
  Scenario: User want to add item 2 times to cart
    Given user is on home page
    When user click add to cart button for this product:
      | Samsung galaxy s6 |
      | Samsung galaxy s7 |
    And user go to the cart page
    And user click delete button to this product:
      | Samsung galaxy s7 |
    And the cart should be contain:
      | Samsung galaxy s6 |
    Then the total price is correct

  @cart-positive-web
  Scenario: User want return to homepage from cart with Product Store logo
    And user click Product Store on top left
    Then user will be directed to home page