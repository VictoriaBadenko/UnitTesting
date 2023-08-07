package yandex.mail.pages;

import static yandex.mail.Locators.LOG_IN;
import static yandex.mail.Locators.USERNAME_INPUT;

public class LoginPage extends BasePage {

    public LoginPage inputUsername() {
        driver.findElement(USERNAME_INPUT).sendKeys("testuserte5t");

        return this;
    }

    public LoginPasswordModule clickLogin() {
        driver.findElement(LOG_IN).click();

        return new LoginPasswordModule();
    }
}
