import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import static org.junit.Assert.assertTrue;


import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class StepDefinitions {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;

    HomePage homePage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("user click on the button")
    public void clickOnTheCreateRouteButton() {
        homePage.clickOnTheCreateRouteButton();


    }


    @And("user enter first location {string} in the field")
    public void userEnterLocationOneInTheField(final String locationOne) {
        homePage.enterLocation1InTheField(locationOne);
    }

    @And("user enter second location {string} in the field")
    public void userEnterSecondLocationTwoInTheField(final String locationTwo) {
        homePage.enterLocation2InTheField(locationTwo);
    }

    @And("user click on transport option button")
    public void userClickOnTransportOptionButton() {
        homePage.clickOnTransportOptionButton();
    }


    @And("user select one in the transport option dropdown list")
    public void inTheTransportOptionDropdownListSelectOne() {
        homePage.clickOnBicycleOption();
    }


    @When("user click Go button")
    public void clickGoButton() {
        homePage.clickOnGoButton();
    }

    @Then("verify the Distance is {string}")
    public void verifyDistanceIsDistance(final String distance) {
        assertTrue(homePage.verifyDistance(distance));



    }
}


