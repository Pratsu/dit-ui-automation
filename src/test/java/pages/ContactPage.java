package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pageHeading = By.xpath("//h6[contains(text(),'Collaborate with Us')]");
    private By indiaLocation = By.xpath("//h4[contains(text(),'India')]");
    private By ukLocation = By.xpath("//h4[contains(text(),'UK')]");
    private By usaLocation = By.xpath("//h4[contains(text(),'USA')]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isPageHeadingVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).isDisplayed();
    }

    public boolean isIndiaLocationVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(indiaLocation)).isDisplayed();
    }

    public boolean isUKLocationVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ukLocation)).isDisplayed();
    }

    public boolean isUSALocationVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usaLocation)).isDisplayed();
    }
}