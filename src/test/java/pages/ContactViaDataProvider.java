package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactViaDataProvider extends BasePage {

    private By txtFirstName = By.name("FirstName");
    private By txtLastName = By.name("LastName");
    private By txtEmail = By.name("your-email");
    private By txtPhone = By.name("Phone");
    private By txtEstimateBudget = By.name("estimatebudget");
    private By ddlHiringModel = By.name("time");
    private By txtProjectDescription = By.name("message");
    private By btnSubmit = By.cssSelector("input.wpcf7-submit");
    private By lblResponseMessage = By.cssSelector(".wpcf7-response-output");

    public ContactViaDataProvider(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        waitUtil.waitForVisibility(txtFirstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUtil.waitForVisibility(txtLastName).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        waitUtil.waitForVisibility(txtEmail).sendKeys(email);
    }

    public void enterPhone(String phone) {
        waitUtil.waitForVisibility(txtPhone).sendKeys(phone);
    }

    public void enterEstimateBudget(String budget) {
        waitUtil.waitForVisibility(txtEstimateBudget).sendKeys(budget);
    }

    public void selectHiringModel(String option) {
        Select select = new Select(waitUtil.waitForVisibility(ddlHiringModel));
        select.selectByVisibleText(option);
    }

    public void enterProjectDescription(String description) {
        waitUtil.waitForVisibility(txtProjectDescription).sendKeys(description);
    }

    public void clickSubmit() {

        WebElement submitButton = waitUtil.waitForVisibility(btnSubmit);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                submitButton);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        submitButton.click();
    }

    public void submitContactForm(String firstName,
                                  String lastName,
                                  String email,
                                  String phone,
                                  String budget,
                                  String hiringModel,
                                  String description) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhone(phone);
        enterEstimateBudget(budget);
        selectHiringModel(hiringModel);
        enterProjectDescription(description);
        clickSubmit();
    }

    public String getResponseMessage() {
        return waitUtil.waitForVisibility(lblResponseMessage)
                .getText()
                .trim();
    }
}