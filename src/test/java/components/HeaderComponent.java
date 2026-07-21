package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponent {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By workLink = By.xpath("//a[contains(@href,'/work')]");

    private By companyDropdownToggle = By.xpath(
            "//a[contains(@class,'quadmenu-dropdown-toggle')][.//span[contains(., 'Company')]]");

    private By aboutLinkInCompanyDropdown = By.xpath(
            "//a[contains(@class,'quadmenu-dropdown-toggle')][.//span[contains(., 'Company')]]" +
                    "/following-sibling::div[contains(@class,'quadmenu-dropdown-menu')]//a[contains(@href,'/about')]");

    private By careersLinkInCompanyDropdown = By.xpath(
            "//a[contains(@class,'quadmenu-dropdown-toggle')][.//span[contains(., 'Company')]]" +
                    "/following-sibling::div[contains(@class,'quadmenu-dropdown-menu')]//a[contains(@href,'/careers')]");

    // Contact's real markup not yet confirmed - left as original locator.
    private By contactLink = By.xpath("//a[contains(@href,'/contact')]");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    public void clickWork() {
        revealHeader();
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(workLink));
        actions.moveToElement(target).pause(Duration.ofMillis(200)).click().perform();
    }

    public void clickAbout() {
        openCompanyDropdown();
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutLinkInCompanyDropdown));
        actions.moveToElement(target).pause(Duration.ofMillis(200)).click().perform();
    }

    public void clickCareers() {
        openCompanyDropdown();
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(careersLinkInCompanyDropdown));
        actions.moveToElement(target).pause(Duration.ofMillis(200)).click().perform();
    }

    private void revealHeader() {
        WebElement body = driver.findElement(By.tagName("body"));
        actions.moveToElement(body, 5, 5).pause(Duration.ofMillis(400)).perform();
    }

    /**
     * The "Company" toggle uses the jQuery hoverintent plugin (see its
     * "hoverintent" CSS class), which only opens after it detects the
     * mouse has genuinely settled over it via real mousemove events -
     * a single instant moveToElement() jump doesn't always register.
     * This nudges the cursor onto the toggle in two small steps with a
     * pause between them, then waits longer for the dropdown to open,
     * which is more reliable against hoverintent's own internal timing.
     */
    private void openCompanyDropdown() {
        revealHeader();
        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(companyDropdownToggle));

        actions.moveToElement(toggle, 2, 2).pause(Duration.ofMillis(150)).perform();
        actions.moveToElement(toggle).pause(Duration.ofMillis(700)).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@class,'quadmenu-dropdown-toggle')][.//span[contains(., 'Company')]]" +
                        "/following-sibling::div[contains(@class,'quadmenu-dropdown-menu')]//a")));
    }
}