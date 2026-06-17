package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static final String BASE_URL = "https://ditinteractive.com/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        String headless = System.getProperty("headless");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        DriverFactory.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.unload();
    }
}