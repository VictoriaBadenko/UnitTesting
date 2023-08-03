package seleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexMailTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginToYandexMail() {
        driver.get("https://mail.yandex.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
