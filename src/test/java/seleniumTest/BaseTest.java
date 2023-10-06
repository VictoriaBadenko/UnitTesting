package seleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import yandex.mail.driverManager.DriverManager;

import static java.time.Duration.ofSeconds;

@ExtendWith(AllureTestWatcher.class)
public class BaseTest {
    protected WebDriver driver;
    protected static String browserInformation;
    protected static byte[] screenshot;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        browserInformation = getBrowserInformation();
        screenshot = makeScreenshot();
        DriverManager.tearDown();
    }

    private byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private String getBrowserInformation() {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        return "Browser Name: " + browserName + ", Browser Version: " + browserVersion;
    }
}
