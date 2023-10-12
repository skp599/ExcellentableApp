package org.addteq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class SearchPageActions {
    private WebDriver driver;

    public SearchPageActions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivk\\Downloads\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void performSearch(String searchText) throws InterruptedException {

        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label=\"Search\"]"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[aria-label=\"Submit\"]"));
        searchInput.sendKeys(searchText);
        searchButton.click();
    }

    public List<String> verifyResultsList( ) {
        List<String> resultTextList = new ArrayList<>();
        List<WebElement> searchResults = driver.findElements(By.cssSelector("[data-vp-id='search-page-results']"));

        // Extract and store the text of each search result in a list
        for (WebElement result : searchResults) {
            resultTextList.add(result.getText());
        }

        return resultTextList;
    }

    public String verifyFirstResult() {
        // Find and click the first search result
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/ul/li[1]/div/a/em"));
        firstResult.click();

        String currentUrl = driver.getCurrentUrl();
        return currentUrl;

    }

    public boolean noSearchResultsPresent() {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("[data-vp-id='search-page-results']"));
        return searchResults.isEmpty(); // If the list is empty, there are no search results
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
