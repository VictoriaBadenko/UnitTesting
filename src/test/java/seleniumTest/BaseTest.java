package seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import yandex.mail.pages.BasePage;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
