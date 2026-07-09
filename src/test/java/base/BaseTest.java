package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import utils.LoggerUtil;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected static final String BASE_URL =
            ConfigReader.getProperty("base.url");

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        LoggerUtil.info("========== TEST SETUP STARTED ==========");
        LoggerUtil.info("Browser: " + browser);

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox":
                LoggerUtil.info("Initializing Firefox browser");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                LoggerUtil.info("Initializing Edge browser");
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-dev-shm-usage");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                LoggerUtil.info("Initializing Chrome browser");
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().window().maximize();
        LoggerUtil.info("Navigating to: " + BASE_URL);
        driver.get(BASE_URL);
        DriverFactory.setDriver(driver);
        LoggerUtil.info("========== TEST SETUP COMPLETED ==========");
    }

    @AfterMethod
    public void tearDown() {
        LoggerUtil.info("========== TEST TEARDOWN STARTED ==========");
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            LoggerUtil.info("Closing browser");
            driver.quit();
        }
        DriverFactory.unload();
        LoggerUtil.info("========== TEST TEARDOWN COMPLETED ==========");
    }
}