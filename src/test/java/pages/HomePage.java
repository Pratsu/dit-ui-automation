package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    private By servicesHeading = By.xpath("//h2[contains(text(),'Our Services')]");
    private By clientTestimonialsHeading = By.xpath("//h2[contains(text(),'What Our Client Says')]");
    private By certifiedHeading = By.xpath("//h2[contains(text(),'Certified')]");
    private By getInTouchButton = By.cssSelector("a.theme_button_secound");
    private By secondGetInTouchButton = By.cssSelector("a.theme_button_secound");
    private By footerBookCallButton = By.cssSelector("a.common-button.work-btn");
    private By calendlyPopup = By.cssSelector(".calendly-overlay");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isServicesVisible() {
        return isElementVisible(servicesHeading);
    }

    public boolean isTestimonialsVisible() {
        return isElementVisible(clientTestimonialsHeading);
    }

    public boolean isCertifiedVisible() {
        return isElementVisible(certifiedHeading);
    }
    public void clickGetInTouch() {
        click(getInTouchButton);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String fetchPageTitle() {
        return getPageTitle();
    }
    public void clickSecondGetInTouch() {
        click(secondGetInTouchButton);
    }
    public void clickFooterBookCall() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < pageHeight; i += 500) {
            js.executeScript("window.scrollTo(0, arguments[0]);", i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        WebElement button = waitUtil.waitForClickability(footerBookCallButton);

        new Actions(driver)
                .moveToElement(button)
                .pause(Duration.ofMillis(500))
                .click()
                .perform();
    }

    public boolean isCalendlyPopupDisplayed() {
        return isElementVisible(calendlyPopup);
    }

}