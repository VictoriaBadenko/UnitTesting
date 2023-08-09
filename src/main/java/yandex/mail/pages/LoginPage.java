package yandex.mail.pages;

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

        return new InboxPage();
    }
}
