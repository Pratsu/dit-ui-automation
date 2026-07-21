package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.LoggerUtil;
import utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    // ===========================
    // Click Methods
    // ===========================

    protected void click(By locator) {
        LoggerUtil.info("Clicking on element: " + locator);
        waitUtil.waitForClickability(locator).click();
    }
    protected void hover(By locator) {

        LoggerUtil.info("Hovering over element: " + locator);

        WebElement element = waitUtil.waitForVisibility(locator);

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void jsClick(By locator) {
        LoggerUtil.info("JavaScript clicking on element: " + locator);

        WebElement element = waitUtil.waitForVisibility(locator);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // ===========================
    // Type Methods
    // ===========================

    protected void type(By locator, String text) {
        LoggerUtil.info("Typing '" + text + "' into element: " + locator);

        WebElement element = waitUtil.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clear(By locator) {
        LoggerUtil.info("Clearing element: " + locator);

        waitUtil.waitForVisibility(locator).clear();
    }

    // ===========================
    // Get Methods
    // ===========================

    protected String getText(By locator) {
        LoggerUtil.info("Getting text from element: " + locator);

        return waitUtil.waitForVisibility(locator)
                .getText()
                .trim();
    }

    protected String getPageTitle() {
        String title = driver.getTitle();

        LoggerUtil.info("Page title: " + title);

        return title;
    }

    // ===========================
    // Visibility
    // ===========================

    protected boolean isElementVisible(By locator) {
        LoggerUtil.info("Checking visibility of element: " + locator);

        return waitUtil.waitForVisibility(locator)
                .isDisplayed();
    }

    // ===========================
    // Dropdown
    // ===========================

    protected void selectByVisibleText(By locator, String value) {

        LoggerUtil.info("Selecting '" + value + "' from dropdown.");

        Select select = new Select(waitUtil.waitForVisibility(locator));

        select.selectByVisibleText(value);
    }

    // ===========================
    // Scroll
    // ===========================

    protected void scrollTo(By locator) {

        LoggerUtil.info("Scrolling to element: " + locator);

        WebElement element = waitUtil.waitForVisibility(locator);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element);
    }

    // ===========================
    // Navigation
    // ===========================

    protected void navigateTo(String url) {

        LoggerUtil.info("Navigating to: " + url);

        driver.get(url);
    }
}