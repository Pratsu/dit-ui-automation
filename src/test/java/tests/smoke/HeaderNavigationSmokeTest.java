package tests.smoke;

import base.BaseTest;
import components.HeaderComponent;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.ContactPage;
import pages.WorkPage;
import utils.LoggerUtil;
import utils.WaitUtil;

public class HeaderNavigationSmokeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void TC_SMK_010_verifyHeaderWorkLinkNavigatesToWorkPage() {
        LoggerUtil.info("Starting test: TC_SMK_010_verifyHeaderWorkLinkNavigatesToWorkPage");

        WebDriver driver = DriverFactory.getDriver();
        HeaderComponent header = new HeaderComponent(driver);

        header.clickWork();

        WorkPage workPage = new WorkPage(driver);
        Assert.assertTrue(workPage.isPageLoaded(),
                "Work page did not load after clicking header 'Work' link");
        Assert.assertTrue(workPage.hasProjects(),
                "No portfolio projects visible after navigating via header 'Work' link");

        LoggerUtil.info("Test passed: TC_SMK_010_verifyHeaderWorkLinkNavigatesToWorkPage");
    }


    @Test(groups = {"smoke"})
    public void TC_SMK_011_verifyHeaderCareersLinkNavigatesToCareersPage() {
        LoggerUtil.info("Starting test: TC_SMK_012_verifyHeaderCareersLinkNavigatesToCareersPage");

        WebDriver driver = DriverFactory.getDriver();
        HeaderComponent header = new HeaderComponent(driver);

        header.clickCareers();

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.isPageHeadingVisible(),
                "Careers page did not load after clicking header 'Careers' link");

        LoggerUtil.info("Test passed: TC_SMK_012_verifyHeaderCareersLinkNavigatesToCareersPage");
    }

    @Test(groups = {"smoke"})
    public void TC_SMK_012_verifyHeaderAboutLinkNavigatesToAboutPage() {
        LoggerUtil.info("Starting test: TC_SMK_013_verifyHeaderAboutLinkNavigatesToAboutPage");

        WebDriver driver = DriverFactory.getDriver();
        HeaderComponent header = new HeaderComponent(driver);

        header.clickAbout();

        boolean landedOnAboutPage = new WaitUtil(driver).waitForUrlContains("about");
        Assert.assertTrue(landedOnAboutPage,
                "URL did not contain 'about' after clicking header 'About' link. Actual URL: " + driver.getCurrentUrl());

        LoggerUtil.info("Test passed: TC_SMK_013_verifyHeaderAboutLinkNavigatesToAboutPage");
    }
}