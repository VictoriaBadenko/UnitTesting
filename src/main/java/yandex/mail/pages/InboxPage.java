package yandex.mail.pages;

import static yandex.mail.Locators.MAIL_CONTAINER;

public class InboxPage extends BasePage {

    public boolean isDisplayedMailContainer() {
        return driver.findElement(MAIL_CONTAINER).isDisplayed();
    }
}
