package tests.smoke;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageSmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void TC_SMK_001_verifyHomePageLoads() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        String title = homePage.fetchPageTitle();
        Assert.assertTrue(title.contains("DIT Interactive"), "Title mismatch. Found: " + title);
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_002_verifyServicesSection() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isServicesVisible(), "Our Services section not visible");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_003_verifyTestimonialsSection() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isTestimonialsVisible(), "Client Testimonials not visible");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_004_verifyCertifiedSection() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isCertifiedVisible(), "Certified section not visible");
    }
}