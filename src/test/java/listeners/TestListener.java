package listeners;

import driver.DriverFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.capture(DriverFactory.getDriver(), result.getName());
    }
}