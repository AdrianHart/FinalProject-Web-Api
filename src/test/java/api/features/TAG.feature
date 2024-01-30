@api
Feature: Automation Rest API DummyIO

  # POSITIVE API TEST
  @tag-positive-api
  Scenario: Get list tag
    When send a "GET" request to the "TAG" endpoint
    Then the status code should be 200
    And the response should be match with "get_tag_users.json"