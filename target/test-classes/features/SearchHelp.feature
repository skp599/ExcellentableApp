Feature: Search Module Verification

  Scenario: Verify the search module with positive test case
    Given I am on the Excellentable page
    When I add the text "Comments" to the search input
    Then I should see correct search results
    And the first result should take me to "Comments"

  Scenario: Verify the search module with negative test case
    Given I am on the Excellentable page
    When I add the text "InvalidText" to the search input
    Then I should see no search results
