package yandex.mail.pages;

import static yandex.mail.Locators.LOG_IN;
import static yandex.mail.Locators.PASSWORD_INPUT;

public class LoginPasswordModule extends BasePage {
    public static final String PASSWORD = "Test951X";

    public LoginPasswordModule inputPassword() {
        driver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);

        return this;
    }

    public InboxPage clickLogin() {
        driver.findElement(LOG_IN).click();

        return new InboxPage();
    }
}
