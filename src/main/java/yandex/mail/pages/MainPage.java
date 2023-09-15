package yandex.mail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public static final String YANDEX_MAIL_URL = "https://mail.yandex.com/";

    @FindBy(id = "header-login-button")
    private WebElement logInButton;

    public MainPage openWebSite() {
        driver.get(YANDEX_MAIL_URL);

        return this;
    }

    public LoginPage openLoginPage() {
        logInButton.click();

        return new LoginPage();
    }

    public boolean isLoginButtonDisplayed() {
        return logInButton.isDisplayed();
    }
}
