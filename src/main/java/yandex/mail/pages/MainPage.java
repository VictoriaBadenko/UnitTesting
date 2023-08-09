package yandex.mail.pages;

import static yandex.mail.Locators.LOG_IN_BUTTON;

public class MainPage extends BasePage {
    public static final String YANDEX_MAIL_URL = "https://mail.yandex.com/";

    public MainPage openWebSite() {
        driver.get(YANDEX_MAIL_URL);

        return this;
    }

    public LoginPage openLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();

        return new LoginPage();
    }
}
