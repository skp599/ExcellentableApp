package org.addteq.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.addteq.SearchPageActions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.util.List;

public class SearchPageSteps {
    private SearchPageActions pageActions;

    @Given("I am on the Excellentable page")
    public void iAmOnTheExcellentablePage() {
        pageActions = new SearchPageActions();
        pageActions.openPage("https://www.excellentable.com/help/");
    }

    @When("I add the text {string} to the search input")
    public void iAddTextToSearchInput(String searchText) throws InterruptedException {
        pageActions.performSearch(searchText);
        Thread.sleep(3000);
    }

    @Then("I should see correct search results")
    public void iSeeCorrectSearchResults() throws InterruptedException {
        // Call verifyResultsList to get the search results
        List<String> searchResults = pageActions.verifyResultsList();

        // Perform assertions to verify the content of the search results
        for (String resultText : searchResults) {
            // Add assertions to verify the content of each search result
            // For example, you can use assertTrue to check if the result contains expected text
            Assert.assertTrue(resultText.contains("comments"));
        Thread.sleep(3000);}
    }

    @And("the first result should take me to {string}")
    public void firstResultTakesToPage(String expectedUrl) {
        // Add code to click the first result and verify the page
        String actualUrl=pageActions.verifyFirstResult();
        Assert.assertEquals("https://www.excellentable.com/help/comments", actualUrl);
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
