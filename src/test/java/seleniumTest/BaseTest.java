package seleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import yandex.mail.driverManager.DriverManager;
import yandex.mail.pages.BasePage;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
