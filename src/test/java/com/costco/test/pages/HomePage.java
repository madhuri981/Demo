package com.costco.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = ":r1c:")
    private WebElement searchBox;

    @FindBy(css = "[aria-label='Submit Search']")
    private WebElement searchButton;

    @FindBy(linkText = "Deals")
    private WebElement dealsLink;

    @FindBy(css = "a[href*='travel']")
    private WebElement travelLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomepage() {
        driver.get("https://www.costco.com");
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        } catch (Exception ignored) {
            // Cookie banner might not be present
        }
    }

    public void enterSearchTerm(String searchTerm) {
       wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.clear();
       searchBox.sendKeys(searchTerm);
       // WebElement searchBox = driver.findElement(By.id("search-field"));
        //searchBox.sendKeys(searchTerm);
       // searchBox.submit();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(Keys.ENTER);
    }

    public void clickDealsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(dealsLink)).click();
    }

    public void clickTravelLink() {
        wait.until(ExpectedConditions.elementToBeClickable(travelLink)).click();
    }
}
