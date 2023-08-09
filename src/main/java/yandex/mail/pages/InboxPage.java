package yandex.mail.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static yandex.mail.Locators.COMPOSE_BUTTON;
import static yandex.mail.Locators.INBOX_TITLE;

public class InboxPage extends BasePage {

    public String getTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(COMPOSE_BUTTON));

        return driver.findElement(INBOX_TITLE).getText();
    }
}
