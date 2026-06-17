package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    protected void click(By locator) {
        waitUtil.waitForClickability(locator).click();
    }

    protected boolean isElementVisible(By locator) {
        return waitUtil.waitForVisibility(locator).isDisplayed();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
}