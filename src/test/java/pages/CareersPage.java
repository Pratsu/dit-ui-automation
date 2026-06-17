package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pageHeading = By.xpath("//h2[contains(text(),'Turning Great Ideas')]");
    private By applyNowLinks = By.xpath("//a[contains(text(),'Apply Now')]");

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isPageHeadingVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).isDisplayed();
    }

    public boolean areJobListingsVisible() {
        return driver.findElements(applyNowLinks).size() > 0;
    }

    public int getJobCount() {
        return driver.findElements(applyNowLinks).size();
    }
}