package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By servicesHeading = By.xpath("//h2[contains(text(),'Our Services')]");
    private By clientTestimonialsHeading = By.xpath("//h2[contains(text(),'What Our Client Says')]");
    private By certifiedHeading = By.xpath("//h2[contains(text(),'Certified')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isServicesVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(servicesHeading)).isDisplayed();
    }

    public boolean isTestimonialsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(clientTestimonialsHeading)).isDisplayed();
    }

    public boolean isCertifiedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(certifiedHeading)).isDisplayed();
    }
}