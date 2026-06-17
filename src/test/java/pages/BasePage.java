package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtil;
import utils.WaitUtil;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    protected void click(By locator) {
        LoggerUtil.info("Clicking on element: " + locator);
        waitUtil.waitForClickability(locator).click();
    }

    protected boolean isElementVisible(By locator) {
        LoggerUtil.info("Checking visibility of element: " + locator);
        return waitUtil.waitForVisibility(locator).isDisplayed();
    }

    protected String getPageTitle() {
        String title = driver.getTitle();
        LoggerUtil.info("Page title: " + title);
        return title;
    }

    protected void navigateTo(String url) {
        LoggerUtil.info("Navigating to: " + url);
        driver.get(url);
    }
}