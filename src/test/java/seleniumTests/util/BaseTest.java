package seleniumTests.util;

import luma.store.driverManager.DriverManager;
import luma.store.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.time.Duration.ofSeconds;

@ExtendWith(AllureTestWatcher.class)
public class BaseTest {
    protected static WebDriver driver;
    protected static MainPage mainPage;
    protected static String browserInformation;
    protected static byte[] screenshot;

    @BeforeAll
    public static void setupDriver() {
        driver = DriverManager.getDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        mainPage = new MainPage();
        mainPage.openMainPage();
    }

    @AfterEach
    public void getTestInformation() {
        browserInformation = getBrowserInformation();
        screenshot = makeScreenshot();
    }

    @AfterAll
    public static void closeBrowser() {
        DriverManager.tearDown();
    }

    private static byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private static String getBrowserInformation() {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        return "Browser Name: " + browserName + ", Browser Version: " + browserVersion;
    }
}
