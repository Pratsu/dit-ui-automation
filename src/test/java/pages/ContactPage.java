package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private By pageHeading = By.xpath("//h6[contains(text(),'Collaborate with Us')]");
    private By indiaLocation = By.xpath("//h4[contains(text(),'India')]");
    private By ukLocation = By.xpath("//h4[contains(text(),'UK')]");
    private By usaLocation = By.xpath("//h4[contains(text(),'USA')]");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageHeadingVisible() {
        return isElementVisible(pageHeading);
    }

    public boolean isIndiaLocationVisible() {
        return isElementVisible(indiaLocation);
    }

    public boolean isUKLocationVisible() {
        return isElementVisible(ukLocation);
    }

    public boolean isUSALocationVisible() {
        return isElementVisible(usaLocation);
    }
}