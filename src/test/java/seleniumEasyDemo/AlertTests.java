package seleniumEasyDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {
    protected Wait<WebDriver> wait;
    private static final String ALERT_BOX_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static final By ALERT_BOX_CLICK_ME_BUTTON = By.xpath("//button[@onclick='myAlertFunction()']");
    private static final By CONFIRM_BOX_CLICK_ME_BUTTON = By.xpath("//button[@onclick='myConfirmFunction()']");
    private static final By CLICK_FOR_PROMPT_BOX_BUTTON = By.xpath("//button[@onclick='myPromptFunction()']");

    @Test
    public void verifyAcceptAlertBox() {
        driver.get(ALERT_BOX_URL);
        driver.findElement(ALERT_BOX_CLICK_ME_BUTTON).click();
        wait = new FluentWait(driver);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test
    public void verifyAcceptConfirmBox() {
        driver.get(ALERT_BOX_URL);
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        wait = new FluentWait(driver);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test
    public void verifyDismissConfirmBox() {
        driver.get(ALERT_BOX_URL);
        driver.findElement(CONFIRM_BOX_CLICK_ME_BUTTON).click();
        wait = new FluentWait(driver);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    @Test
    public void verifyAcceptPromptBox() {
        driver.get(ALERT_BOX_URL);
        driver.findElement(CLICK_FOR_PROMPT_BOX_BUTTON).click();
        wait = new FluentWait(driver);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Prompt Box Test");
        alert.accept();
    }
}
