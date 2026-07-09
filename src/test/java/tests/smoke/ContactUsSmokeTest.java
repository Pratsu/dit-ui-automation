package tests.smoke;

import base.BaseTest;
import dataprovider.ContactDataProvider;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactViaDataProvider;
import utils.ConfigReader;
import utils.LoggerUtil;

public class ContactUsSmokeTest extends BaseTest {

    @Test(
            groups = {"smoke"},
            dataProvider = "ContactData",
            dataProviderClass = ContactDataProvider.class
    )
    public void TC_SMK_009_verifyContactInquirySubmission(
            String firstName,
            String lastName,
            String email,
            String phone,
            String budget,
            String hiringModel,
            String description) {

        LoggerUtil.info("Starting test: TC_SMK_009_verifyContactInquirySubmission");

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("contact.url"));

        ContactViaDataProvider contactPage = new ContactViaDataProvider(driver);

        contactPage.submitContactForm(
                firstName,
                lastName,
                email,
                phone,
                budget,
                hiringModel,
                description
        );

        String actualMessage = contactPage.getResponseMessage();

        LoggerUtil.info("Response Message: " + actualMessage);

        Assert.assertEquals(
                actualMessage,
                "One or more fields have an error. Please check and try again.",
                "Unexpected response message."
        );

        LoggerUtil.info("Test passed: Validation message verified successfully.");
    }
}