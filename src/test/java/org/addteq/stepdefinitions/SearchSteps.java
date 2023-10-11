package org.addteq.stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchSteps {
    private WebDriver driver;

    @Given("I am on the Excellentable page")
    public void iAmOnTheExcellentablePage() {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/sukhd/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Additional options if needed
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.excellentable.com/help/");
    }

    @When("I add the text {string} to the search input")
    public void iAddTextToSearchInput(String searchText) {
        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label=\"Search\"]"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[aria-label=\"Submit\"]"));// Replace with actual locator
        searchInput.sendKeys(searchText);
        searchButton.click();

    }

    @Then("I should see correct search results")
    public void iSeeCorrectSearchResults() {
        // Add code to verify search results
    }

    @And("the first result should take me to {string}")
    public void firstResultTakesToPage(String expectedPage) {
        // Add code to click the first result and verify the page
    }

    @Then("I should see no search results")
    public void iSeeNoSearchResults() {
        // Add code to verify there are no search results
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
