Feature: Automation Rest API DummyIO

  # POSITIVE API TEST
  @post-positive-api
  Scenario: Post create a new user normal
    Given prepare url for setup "CREATE_NEW_USERS"
    When send a "POST" request to the "CREATE" endpoint
    Then the status code should be 200
    Then the response body post create new user
    Then the response body should not be empty
    And the response should be match with "post_create_users.json"

  # NEGATIVE API TEST
  @post-negative-api
  Scenario: Post create a new user error after fill the name with symbol
  And the request body is set to:
      | firstName       | @@@@@@@                  |
      | lastName        | wrongsymbol              |
      | email           | test@yahoo.com           |
  When send a "POST" request to the "CREATE" endpoint
  Then the status code should be 400
  And the response body should contain:
      | error           | BODY_NOT_VALID           |
      | data.firstName  | firstName cannot contain special characters, use letters only |

  @post-negative-api
  Scenario: Post create a new user error after fill the name with number
  And the request body is set to:
      | firstName       | 1111111                  |
      | lastName        | wrongnumber              |
      | email           | test@yahoo.com           |
  When send a "POST" request to the "CREATE" endpoint
  Then the status code should be 400
  And the response body should contain:
      | error           | BODY_NOT_VALID           |
      | data.firstName  | firstName cannot contain number characters, use letters only |