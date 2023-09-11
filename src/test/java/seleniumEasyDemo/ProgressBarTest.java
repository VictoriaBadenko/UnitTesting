package seleniumEasyDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends BaseTest {
    private static final String PROGRESS_DEMO_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private static final By PERCENT_TEXT = By.className("percenttext");

    @Test
    public void verifyProgressBar() {
        driver.get(PROGRESS_DEMO_URL);
        driver.findElement(DOWNLOAD_BUTTON).click();
        WebElement percentText = driver.findElement(PERCENT_TEXT);
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.textToBePresentInElement(percentText, "50%"));
        driver.navigate().refresh();
    }
}
