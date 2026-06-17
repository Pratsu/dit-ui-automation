package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPlannerPage extends BasePage {

    private By plannerForm = By.tagName("form");
    private By yourNameField = By.xpath("//label[contains(text(),'Your Name')]");
    private By emailField = By.xpath("//label[contains(text(),'email')]");
    private By phoneField = By.xpath("//label[contains(text(),'Phone')]");
    private By businessNameField = By.xpath("//label[contains(text(),'Business name')]");
    private By digitalMarketingQuestion = By.xpath("//*[contains(text(),'digital marketing')]");
    private By googleServicesQuestion = By.xpath("//*[contains(text(),'google related services')]");

    public ProjectPlannerPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProjectPlanner() {
        driver.get("https://ditinteractive.com/project-planner/");
    }

    public boolean isFormVisible() {
        return isElementVisible(plannerForm);
    }

    public boolean isYourNameFieldVisible() {
        return isElementVisible(yourNameField);
    }

    public boolean isEmailFieldVisible() {
        return isElementVisible(emailField);
    }

    public boolean isPhoneFieldVisible() {
        return isElementVisible(phoneField);
    }

    public boolean isBusinessNameFieldVisible() {
        return isElementVisible(businessNameField);
    }

    public boolean isDigitalMarketingQuestionVisible() {
        return isElementVisible(digitalMarketingQuestion);
    }

    public boolean isGoogleServicesQuestionVisible() {
        return isElementVisible(googleServicesQuestion);
    }
}