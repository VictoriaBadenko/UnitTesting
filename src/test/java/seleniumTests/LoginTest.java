package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static luma.store.helpers.Constants.EMAIL;
import static luma.store.helpers.Constants.PASSWORD;

public class LoginTest extends BaseTest {

    @Test
    @AllureId("AP-2")
    @Description("Verify the user ability to login in account")
    public void testSuccessfulLogin() {
        var isUserLoggedIn = mainPage
                .clickSignIn()
                .login(EMAIL, PASSWORD)
                .isWelcomeMessageDisplayed();
        assertTrue(isUserLoggedIn);
    }
}
