Feature: Automation Rest API DummyIO

  # POSITIVE API TEST
  @get-positive-api
  Scenario: Get list data users
    Given prepare url for setup
    When send a "GET_LIST_USERS" request to the list data
    Then the status code should be 200
    Then validation response body get list users
    And the response should be match with "get_list_users.json"

  @get-positive-api
  Scenario: Get list full data users by id
    Given prepare url for setup
    When send a request "GET_LIST_USERS_ID" with id "60d0fe4f5311236168a109ca"
    Then the status code should be 200
    Then validation response body get list users id
    And the response should be match with "get_list_single_users.json"

 # NEGATIVE API TEST
  @get-negative-api
  Scenario: Get users full data with wrong id
    Given prepare url for setup
    When send a request "GET_WRONG_USERS_ID" with id "0123"
    Then the status code should be 400
    And the response body should contain:
      | error | PARAMS_NOT_VALID |

  @get-negative-api
  Scenario: Get get users full data with id symbol "@"
    Given prepare url for setup
    When send a request "GET_WRONG_SYMBOL_USERS_ID" with id "@60d0fe4f5311236168a109ca"
    Then the status code should be 400
    And the response body should contain:
      | error | PARAMS_NOT_VALID |