package tests.regression;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPlannerPage;

public class RegressionTest extends BaseTest {

    @Test(groups = {"regression"})
    public void TC_REG_001_verifyProjectPlannerPageLoads() {
        ProjectPlannerPage page = new ProjectPlannerPage(DriverFactory.getDriver());
        page.navigateToProjectPlanner();
        Assert.assertTrue(page.isFormVisible(), "Project Planner form not visible");
    }

    @Test(groups = {"regression"})
    public void TC_REG_002_verifyRequiredFieldsVisible() {
        ProjectPlannerPage page = new ProjectPlannerPage(DriverFactory.getDriver());
        page.navigateToProjectPlanner();

        Assert.assertTrue(page.isYourNameFieldVisible(), "Your Name field not visible");
        Assert.assertTrue(page.isEmailFieldVisible(), "Email field not visible");
        Assert.assertTrue(page.isPhoneFieldVisible(), "Phone field not visible");
        Assert.assertTrue(page.isBusinessNameFieldVisible(), "Business Name field not visible");
    }

    @Test(groups = {"regression"})
    public void TC_REG_003_verifyMarketingQuestionsVisible() {
        ProjectPlannerPage page = new ProjectPlannerPage(DriverFactory.getDriver());
        page.navigateToProjectPlanner();

        Assert.assertTrue(page.isDigitalMarketingQuestionVisible(), "Digital marketing question not visible");
        Assert.assertTrue(page.isGoogleServicesQuestionVisible(), "Google services question not visible");
    }
}