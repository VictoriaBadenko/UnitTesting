package seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import yandex.mail.pages.BasePage;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
