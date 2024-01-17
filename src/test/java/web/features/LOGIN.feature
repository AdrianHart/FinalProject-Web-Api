Feature: Automation WEB Demoblaze

  # POSITIVE API TEST
  @login-positive-web
  Scenario Outline: User login with valid username and password
    Given user is on home page
    When user click login menu
    And user input username <username>
    And user input password <password>
    And user click login button
    And user validate to home page
    And user successfully login with valid username and password
    Examples:
      | username     | password     |
      | "adrianTest" | "adrianTest" |

  @login-positive-web
  Scenario Outline: User want to logout
    Given user is on home page
    When user click login menu
    And user input username <username>
    And user input password <password>
    And user click login button
    And user validate to home page
    And user click logout menu
    Examples:
      | username     | password     |
      | "adrianTest" | "adrianTest" |

  @login-positive-web
  Scenario: User close the login menu
    Given user is on home page
    When user click login menu
    And user click close button
    Then user will be directed to home page

  # NEGATIVE API TEST
  @login-negative-web
  Scenario: User login with invalid username
    Given user is on home page
    When user click login menu
    And user input username "adrianTest100"
    And user input password "adrianTest"
    And user click login button
    Then user see a message alert "User does not exist."

  @login-negative-web
  Scenario: User login with invalid password
    Given user is on home page
    When user click login menu
    And user input username "adrianTest"
    And user input password "invalidpassword"
    And user click login button
    Then user see a message alert "Wrong password."
