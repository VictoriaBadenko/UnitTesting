package luma.store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static luma.store.helpers.Constants.LUNA_URL;

public class MainPage extends BasePage {
    @FindBy(css = "li.authorization-link a")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text() = 'Create an Account']")
    private WebElement createAnAccountButton;

    public void openMainPage() {
        driver.get(LUNA_URL);
    }

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage();
    }

    public CreateNewAccountPage openCreateAccountPage() {
        createAnAccountButton.click();
        return new CreateNewAccountPage();
    }
}
