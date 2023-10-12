package org.addteq.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.addteq.SearchPageActions;
import org.junit.Assert;

import java.util.List;

public class SearchPageSteps {
    private SearchPageActions pageActions;

    @Given("I am on the Excellentable page")
    public void iAmOnTheExcellentablePage() {
        pageActions = new SearchPageActions();
        pageActions.openPage("https://www.excellentable.com/help/");
    }

    @When("I add the text {string} to the search input")
    public void iAddTextToSearchInput(String searchText) {
        pageActions.performSearch(searchText);
    }

    @Then("I should see correct search results")
    public void iSeeCorrectSearchResults() {
        // Call verifyResultsList to get the search results
        List<String> searchResults = pageActions.verifyResultsList();

        // Perform assertions to verify the content of the search results
        for (String resultText : searchResults) {
            // Add assertions to verify the content of each search result
            // For example, you can use assertTrue to check if the result contains expected text
            Assert.assertTrue(resultText.contains("test"));
        }
    }

    @And("the first result should take me to {string}")
    public void firstResultTakesToPage() {
        // Add code to click the first result and verify the page
        String actualUrl=pageActions.verifyFirstResult();
        Assert.assertEquals("https://www.excellentable.com/help/test-page", actualUrl);
    }

    @Then("I should see no search results")
    public void iSeeNoSearchResults() {
        // Add code to verify there are no search results
        boolean noSearchResults = pageActions.noSearchResultsPresent();
        Assert.assertTrue(noSearchResults);
    }

    @After
    public void tearDown() {
        if (pageActions != null) {
            pageActions.closeBrowser();
        }
    }
}
