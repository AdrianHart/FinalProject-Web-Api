@web
Feature: Automation WEB Demoblaze

  # POSITIVE WEB TEST
  @homepage-positive-web
  Scenario: User want to see all item on home page
    Given user is on home page
    And user validate to home page
    When user see all products on the first page
    And user click next menu
    And user see all products on the second page
    And user click previous menu
    Then user will be directed to first page

  @homepage-positive-web
  Scenario: User want to refresh page
    Given user is on home page
    And user click next menu
    And user click Product Store on top left
    Then user will be directed to home page