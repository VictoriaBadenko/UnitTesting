package yandex.mail.pages;

import static yandex.mail.Locators.LOG_IN_BUTTON;

public class MainPage extends BasePage {

    public MainPage openWebSite() {
        driver.get("https://mail.yandex.com/");

        return this;
    }

    public LoginPage openLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();

        return new LoginPage();
    }
}
