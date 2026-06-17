package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeaderComponent {
    private WebDriver driver;
    private WebDriverWait wait;

    private By contactLink = By.xpath("//a[contains(@href,'/contact')]");
    private By careersLink = By.xpath("//a[contains(@href,'/careers')]");
    private By aboutLink = By.xpath("//a[contains(@href,'/about')]");
    private By workLink = By.xpath("//a[contains(@href,'/work')]");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    public void clickCareers() {
        wait.until(ExpectedConditions.elementToBeClickable(careersLink)).click();
    }

    public void clickAbout() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink)).click();
    }

    public void clickWork() {
        wait.until(ExpectedConditions.elementToBeClickable(workLink)).click();
    }
}