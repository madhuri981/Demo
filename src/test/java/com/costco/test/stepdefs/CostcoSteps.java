package com.costco.test.stepdefs;
import com.costco.test.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class CostcoSteps {
    private WebDriver driver;
    private HomePage homePage;
    private WebDriverWait wait;

    @Before
    public void setup() {
    	  ChromeOptions options = new ChromeOptions();
  	    options.addArguments("--remote-allow-origins=*");
  	    // Optional but recommended options
  	    options.addArguments("--no-sandbox");
  	    options.addArguments("--disable-dev-shm-usage");
  	    
  	    // Set ChromeDriver path
  	    System.setProperty("webdriver.chrome.driver", "C:\\\\WebDriver\\\\bin\\\\chromedriver.exe");
  	    
  	    driver = new ChromeDriver(options);
  	    driver.manage().window().maximize();
  	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on Costco homepage")
    public void i_am_on_costco_homepage() {
        homePage.navigateToHomepage();
    }

    @When("I enter {string} in the search box")
    public void i_enter_in_the_search_box(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        homePage.clickSearchButton();
    }

    @Then("I should see laptop search results")
    public void i_should_see_laptop_search_results() {
        assertTrue(driver.getPageSource().toLowerCase().contains("laptop"));
    }

    @When("I click on the Deals link")
    public void i_click_on_the_deals_link() {
        homePage.clickDealsLink();
    }

    @Then("I should be redirected to the Deals page")
    public void i_should_be_redirected_to_the_deals_page() {
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("deals"));
    }

    @When("I click on the Travel link")
    public void i_click_on_the_travel_link() {
        homePage.clickTravelLink();
    }

    @Then("I should be redirected to the Travel page")
    public void i_should_be_redirected_to_the_travel_page() {
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("travel"));
    }
}
