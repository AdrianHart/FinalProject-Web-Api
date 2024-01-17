Feature: Automation Rest API DummyIO

  # POSITIVE API TEST
  @put-positive-api
  Scenario: Put update data user with valid data normal
    When send a "PUT" request to the "userId01" endpoint
    Then the status code should be 200
    Then the response body put update data user
    Then the response body should not be empty
    And the response should be match with "put_update_users.json"

  # NEGATIVE API TEST
  @put-negative-api
  Scenario: Put update fill data user with a symbol
    And the request body is set to:
      | firstName       | adrian                   |
      | lastName        | hartanto                 |
      | email           | test@yahoo.com           |
    When send a "PUT" request to the "UPDATE" endpoint
    And the request body is set to:
      | firstName       | @@@@@@@                  |
      | lastName        | hartanto                 |
      | email           | test@yahoo.com           |
    Then the status code should be 400
    And the response body should contain:
      | error           | BODY_NOT_VALID           |
      | data.firstName  | firstName cannot contain special characters, use letters only |