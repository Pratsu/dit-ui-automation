package tests.smoke;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.LoggerUtil;

public class HomePageSmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void TC_SMK_001_verifyHomePageLoads() {
        LoggerUtil.info("Starting test: TC_SMK_001_verifyHomePageLoads");
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        String title = homePage.fetchPageTitle();
        Assert.assertTrue(title.contains("DIT Interactive"), "Title mismatch. Found: " + title);
        LoggerUtil.info("Test passed: TC_SMK_001_verifyHomePageLoads");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_002_verifyServicesSection() {
        LoggerUtil.info("Starting test: TC_SMK_002_verifyServicesSection");
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isServicesVisible(), "Our Services heading not visible");
        LoggerUtil.info("Test passed: TC_SMK_002_verifyServicesSection");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_003_verifyTestimonialsSection() {
        LoggerUtil.info("Starting test: TC_SMK_003_verifyTestimonialsSection");
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isTestimonialsVisible(), "Client Testimonials section not visible");
        LoggerUtil.info("Test passed: TC_SMK_003_verifyTestimonialsSection");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_004_verifyCertifiedSection() {
        LoggerUtil.info("Starting test: TC_SMK_004_verifyCertifiedSection");
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isCertifiedVisible(), "Certified section not visible");
        LoggerUtil.info("Test passed: TC_SMK_004_verifyCertifiedSection");
    }
}