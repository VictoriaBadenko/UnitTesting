package yandex.mail.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static yandex.mail.Locators.INBOX_TITLE;

public class InboxPage extends BasePage {

    public String getTitle() {
        new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.urlContains("?uid=1876203154#tabs/relevant"));

        return driver.findElement(INBOX_TITLE).getText();
    }
}
