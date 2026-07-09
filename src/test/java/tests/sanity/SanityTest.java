package tests.sanity;

 import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WorkPage;

public class SanityTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void TC_SAN_001_verifyWorkPageLoads() {
        WorkPage workPage = new WorkPage(DriverFactory.getDriver());
        workPage.navigateToWork();
        Assert.assertTrue(workPage.isPageLoaded(), "Work page did not load");
    }

    @Test(groups = {"sanity"})
    public void TC_SAN_002_verifyWorkPageHasProjects() {
        WorkPage workPage = new WorkPage(DriverFactory.getDriver());
        workPage.navigateToWork();
        Assert.assertTrue(workPage.hasProjects(), "No portfolio projects found");
    }
}