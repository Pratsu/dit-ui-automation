package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ServicesPage extends BasePage {

    public ServicesPage(WebDriver driver) {
        super(driver);
    }

    private final By ourServicesMenu = By.cssSelector(
            "#menu-item-27617 > a.quadmenu-dropdown-toggle");

    private final By shopifyService = By.cssSelector(
            "#menu-item-27631 > a");

    public void hoverOnServicesMenu() {
        revealHeader();
        hover(ourServicesMenu);
    }

    public void clickShopifyService() {
        click(shopifyService);
    }

    public String getCurrentPageTitle() {
        return getPageTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * This site's header only reveals itself once the cursor moves near
     * the top of the page - same reveal step HeaderComponent.revealHeader()
     * uses, kept local here rather than in BasePage so it only affects
     * ServicesPage.
     */
    private void revealHeader() {
        WebElement body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 5, 5)
                .pause(Duration.ofMillis(400))
                .perform();
    }
}