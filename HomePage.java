package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    @FindBy(xpath = "//div[@id='content']//select[@class='routing_engines form-select form-select-sm']")
    private WebElement transportOptionButton;
    @FindBy(xpath = "//div[@id='content']//a[@class='btn btn-sm btn-primary switch_link']")
    private WebElement createRouteButton;
    @FindBy(xpath = "(//div[@id='content']//div[@class='col']//input[@class='form-control form-control-sm'])[2]")
    private WebElement location1Field;
    @FindBy(xpath = "(//div[@id='content']//div[@class='col']//input[@class='form-control form-control-sm'])[3]")
    private WebElement location2Field;
    @FindBy(xpath = "(//*[contains(text(), 'Велосипед (OSRM)')])[2]")
    private WebElement bicycleOption;
    @FindBy(xpath = "//div[@id='content']//div[@class='col-auto']//input[@type='submit']")
    private WebElement goButton;
    @FindBy(xpath = "//p[contains(text(), 'Відстань')]")
    private WebElement distanceOfTheRoute;


    public void openHomePage(final String url) {
        driver.get(url);
    }

    public void clickOnTheCreateRouteButton() {
        createRouteButton.click();
    }

    public void enterLocation1InTheField(String searchLocation) {
        location1Field.clear();
        location1Field.sendKeys(searchLocation);

    }
    public void enterLocation2InTheField(String searchLocation) {
        location2Field.clear();
        location2Field.sendKeys(searchLocation);

    }

    public void clickOnTransportOptionButton() {
        transportOptionButton.click();

    }

    public void clickOnBicycleOption() {
        bicycleOption.click();

    }

    public void clickOnGoButton() {
        goButton.click();
    }

    public boolean verifyDistance(String expectedDistance){
        return distanceOfTheRoute.getText().contains(expectedDistance+"km");

    }
}
