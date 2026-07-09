package tests.smoke;

import base.BaseTest;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.ContactPage;
import utils.ConfigReader;

public class NavigationSmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void TC_SMK_005_verifyContactPageLoads() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("contact.url"));

        ContactPage contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.isPageHeadingVisible(), "Contact page did not load");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_006_verifyCareersPageLoads() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("careers.url"));

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.isPageHeadingVisible(), "Careers page did not load");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_007_verifyContactPageLocations() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("contact.url"));

        ContactPage contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.isIndiaLocationVisible(), "India location not visible");
        Assert.assertTrue(contactPage.isUKLocationVisible(), "UK location not visible");
        Assert.assertTrue(contactPage.isUSALocationVisible(), "USA location not visible");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_008_verifyCareersJobListings() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("careers.url"));

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.areJobListingsVisible(), "No job listings found");
    }
}