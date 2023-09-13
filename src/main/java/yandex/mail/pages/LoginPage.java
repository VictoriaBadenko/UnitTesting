package yandex.mail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "#passp-field-login")
    WebElement usernameInput;

    @FindBy(id = "passp:sign-in")
    WebElement logInButton;

    @FindBy(xpath = "//button[contains(@class, 'Button2_type_submit')]")
    WebElement logInToMailButton;

    @FindBy(name = "passwd")
    WebElement passwordInput;

    public LoginPage inputUsername(String userName) {
        usernameInput.sendKeys(userName);

        return this;
    }

    public LoginPage clickLogin() {
        logInButton.click();

        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);

        return this;
    }

    public InboxPage clickLoginToMail() {
        logInToMailButton.click();

        return new InboxPage();
    }

    public InboxPage loginToYandexMail(String userName, String password) {
        inputUsername(userName);
        clickLogin();
        inputPassword(password);
        clickLoginToMail();

        return new InboxPage();
    }
}
