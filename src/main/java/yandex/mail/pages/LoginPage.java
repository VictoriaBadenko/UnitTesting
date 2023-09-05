package yandex.mail.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static yandex.mail.Locators.*;

public class LoginPage extends BasePage {

    public LoginPage inputUsername(String userName) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);

        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(LOG_IN).click();

        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);

        return this;
    }

    public InboxPage clickLoginToMail() {
        driver.findElement(LOG_IN_TO_MAIL).click();

        new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(USERNAME_LABEL));

        return new InboxPage();
    }
}
