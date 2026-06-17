package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By servicesHeading = By.xpath("//h2[contains(text(),'Our Services')]");
    private By clientTestimonialsHeading = By.xpath("//h2[contains(text(),'What Our Client Says')]");
    private By certifiedHeading = By.xpath("//h2[contains(text(),'Certified')]");

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

    public String fetchPageTitle() {
        return getPageTitle();
    }
}