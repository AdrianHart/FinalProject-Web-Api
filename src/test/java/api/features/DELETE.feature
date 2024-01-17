Feature: Automation Rest API DummyIO

  # POSITIVE API TEST
  @delete-positive-api
  Scenario: Delete data user with registered id
    When send a "DELETE" request to the "userId01" endpoint
    Then the status code should be 200
    And the response should be match with "delete_users.json"

# NEGATIVE API TEST
  @delete-negative-api
  Scenario: Delete data user with unregistered id
    When send a "DELETE" request to the "userId999" endpoint
    Then the status code should be 400
    And the response should be match with "delete_users.json"
    And the response body should contain:
      | error           | NOT_VALID           |