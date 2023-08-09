package yandex.mail.pages;

import static yandex.mail.Locators.LOG_IN;
import static yandex.mail.Locators.USERNAME_INPUT;

public class LoginPage extends BasePage {
    public static final String USER_NAME = "testuserte5t";

    public LoginPage inputUsername() {
        driver.findElement(USERNAME_INPUT).sendKeys(USER_NAME);

        return this;
    }

    public LoginPasswordModule clickLogin() {
        driver.findElement(LOG_IN).click();

        return new LoginPasswordModule();
    }
}
