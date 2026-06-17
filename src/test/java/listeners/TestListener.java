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
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html");
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("DIT Automation Report");
            htmlReporter.config().setReportName("Smoke Test Results");
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
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory("Smoke");
        test.assignAuthor("QA Automation");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " - Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " - Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        String path = ScreenshotUtil.capture(DriverFactory.getDriver(), result.getName());
        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " - Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}