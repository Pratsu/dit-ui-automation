package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html");
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("DIT Automation Report");
            htmlReporter.config().setReportName("Test Results");
            htmlReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Project", "DIT Interactive");
        }
        return extent;
    }

    @Override
    public void onStart(ITestContext context) {
        getExtent();
        LoggerUtil.info("========== SUITE STARTED: " + context.getName() + " ==========");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory("Smoke");
        test.assignAuthor("QA Automation");
        LoggerUtil.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " - Passed");
        LoggerUtil.info("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " - Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        LoggerUtil.error("Test FAILED: " + result.getName());
        LoggerUtil.error("Reason: " + result.getThrowable().getMessage());

        try {
            String path = ScreenshotUtil.capture(DriverFactory.getDriver(), result.getName());
            test.addScreenCaptureFromPath(path);
            LoggerUtil.info("Screenshot captured: " + path);
        } catch (Exception e) {
            LoggerUtil.error("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " - Skipped");
        LoggerUtil.info("Test SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        LoggerUtil.info("========== SUITE FINISHED: " + context.getName() + " ==========");
    }
}