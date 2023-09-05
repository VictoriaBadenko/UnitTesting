package seleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitingUserTest extends BaseTest {
    private static final String DYNAMIC_DATA_LOADING_URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    private static final By GET_NEW_USER_BUTTON = By.id("save");
    private static final By USER_DATA = By.xpath("//div[contains(text(),'First')]");

    @Test
    public void verifyWaitingForUser() {
        driver.get(DYNAMIC_DATA_LOADING_URL);
        driver.findElement(GET_NEW_USER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(USER_DATA));
    }
}
