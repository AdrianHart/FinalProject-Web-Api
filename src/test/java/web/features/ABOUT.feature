Feature: Automation WEB Demoblaze

  # POSITIVE API TEST
  @aboutus-positive-test
  Scenario: User want to see about demoblaze
    Given user is on home page
    When user click about us menu
    And user validate to about us menu
    And user play video from about us for get information
    And user click close button from about us