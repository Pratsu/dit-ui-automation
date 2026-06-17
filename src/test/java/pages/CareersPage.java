package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    private By pageHeading = By.xpath("//h2[contains(text(),'Turning Great Ideas')]");
    private By applyNowLinks = By.xpath("//a[contains(text(),'Apply Now')]");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageHeadingVisible() {
        return isElementVisible(pageHeading);
    }

    public boolean areJobListingsVisible() {
        return driver.findElements(applyNowLinks).size() > 0;
    }

    public int getJobCount() {
        return driver.findElements(applyNowLinks).size();
    }
}