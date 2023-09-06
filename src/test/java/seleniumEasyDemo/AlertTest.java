package seleniumEasyDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTest extends BaseTest {
    private Wait<WebDriver> wait;
    private static final String ALERT_BOX_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static final By ALERT_BOX_CLICK_ME_BUTTON = By.xpath("//button[@onclick='myAlertFunction()']");
    private static final By CONFIRM_BOX_CLICK_ME_BUTTON = By.xpath("//button[@onclick='myConfirmFunction()']");
    private static final By CLICK_FOR_PROMPT_BOX_BUTTON = By.xpath("//button[@onclick='myPromptFunction()']");
    private final static By RESULT_TEXT = By.xpath("//p[@id='confirm-demo']");
    private final static By PROMPT_BOX_ALERT_TEXT = By.xpath("//p[@id='prompt-demo']");
    private final static String TEST_WORD = "Test";

    @BeforeMethod
    public void setWait() {
        driver.get(ALERT_BOX_URL);
        wait = new FluentWait<>(driver);
    }

    @Test
    public void verifyAlertBox() {
        driver.findElement(ALERT_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        var alertText = alert.getText();

        assertEquals(alertText, "I am an alert box!", "Actual and expected alert text don't match.");
    }

    @Test
    public void verifyConfirmBox() {
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        var alertText = alert.getText();

        assertEquals(alertText, "Press a button!", "Actual and expected alert text don't match.");
    }

    @Test
    public void verifyDismissConfirmBox() {
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        var resultMessage = driver.findElement(RESULT_TEXT);

        assertTrue(resultMessage.getText().contains("Cancel"), "Cancel text message should be displayed");
    }

    @Test
    public void verifyAcceptPromptBox() {
        driver.findElement(CLICK_FOR_PROMPT_BOX_BUTTON).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(TEST_WORD);
        alert.accept();
        var actualText = driver.findElement(PROMPT_BOX_ALERT_TEXT).getText();

        assertTrue(actualText.contains(TEST_WORD), "Actual and expected alert text don't match.");
    }
}
