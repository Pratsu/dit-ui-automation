package tests.regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pages.ServicesPage;

public class ServicesTest extends BaseTest {

    @Test
    public void verifyShopifyServiceNavigation() {

        ServicesPage servicesPage =
                new ServicesPage(DriverFactory.getDriver());

        servicesPage.hoverOnServicesMenu();

        servicesPage.clickShopifyService();

        Assert.assertTrue(
                servicesPage.getCurrentUrl().contains("shopify-development"),
                "Shopify page did not open");
    }
}