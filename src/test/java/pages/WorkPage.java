package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkPage extends BasePage {

    private By projectCards = By.xpath("//a[contains(@href,'/portfolio/')]");

    public WorkPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToWork() {
        driver.get("https://ditinteractive.com/work/");
    }

    public boolean isPageLoaded() {
        return getPageTitle().toLowerCase().contains("portfolio");
    }

    public boolean hasProjects() {
        return driver.findElements(projectCards).size() > 0;
    }
}