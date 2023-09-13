package yandex.mail.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public static final String YANDEX_MAIL_URL = "https://mail.yandex.com/";
    public static final By LOG_IN_BUTTON = By.id("header-login-button");

    public MainPage openWebSite() {
        driver.get(YANDEX_MAIL_URL);

        return this;
    }

    public LoginPage openLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();

        return new LoginPage();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOG_IN_BUTTON).isDisplayed();
    }
}
