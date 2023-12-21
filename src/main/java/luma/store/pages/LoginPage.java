package luma.store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement signInButton;

    private void inputEmailField(String email) {
        emailField.sendKeys(email);
    }

    private void inputPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    private void clickSignInButton() {
        signInButton.click();
    }

    public HomePage login(String email, String password) {
        inputEmailField(email);
        inputPasswordField(password);
        clickSignInButton();
        return new HomePage();
    }
}
