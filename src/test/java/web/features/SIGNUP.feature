@web
Feature: Automation WEB Demoblaze

  # POSITIVE WEB TEST
  @signup-positive-web
  Scenario Outline: User want to create new account
    Given user is on home page
    When user click sign up menu
    And user input form username <username>
    And user input form password <password>
    And user click sign up button
    Then user see a message alert "Sign up successful."
    Examples:
      | username          | password     |
      | "randomUser"      | "adrianTest" |
      | "randomNum"       | "adrianTest" |
#    adrianTest01 | adrianTest : manual username ganti disini angkanya aja

  # NEGATIVE WEB TEST
  @signup-negative-web
  Scenario: User want to create new account with empty username and password
    Given user is on home page
    When user click sign up menu
    And user click sign up button
    Then user see a message alert "Please fill out Username and Password."

  @signup-negative-web
  Scenario Outline: User sign up with existed username
    Given user is on home page
    When user click sign up menu
    And user input form username <username>
    And user input form password <password>
    And user click sign up button
    Then user see a message alert "This user already exist."
    Examples:
      | username     | password     |
      | "adrianTest" | "adrianTest" |
