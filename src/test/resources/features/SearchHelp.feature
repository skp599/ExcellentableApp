Feature: Search Module Verification

  Scenario: Verify the search module with positive test case
    Given I am on the Excellentable page
    When I add the text "Test" to the search input
    Then I should see correct search results
    And the first result should take me to "Test"

  Scenario: Verify the search module with negative test case
    Given I am on the Excellentable page
    When I add the text "InvalidText" to the search input
    Then I should see no search results
