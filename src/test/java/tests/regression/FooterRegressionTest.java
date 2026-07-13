package tests.regression;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.LoggerUtil;

public class FooterRegressionTest extends BaseTest {

    @Test(
            priority = 1,
            groups = {"Regression"},
            description = "TC_REG_FOOTER_001 - Verify Footer Book a Call opens Calendly popup"
    )
    public void TC_REG_FOOTER_001_verifyFooterBookCallOpensCalendlyPopup() {

        LoggerUtil.info("========== TC_REG_FOOTER_001 Started ==========");

        HomePage homePage = new HomePage(DriverFactory.getDriver());

        homePage.clickFooterBookCall();

        Assert.assertTrue(
                homePage.isCalendlyPopupDisplayed(),
                "Calendly popup was not displayed after clicking Book a Call."
        );

        LoggerUtil.info("Calendly popup displayed successfully.");

        LoggerUtil.info("========== TC_REG_FOOTER_001 Passed ==========");
    }
}