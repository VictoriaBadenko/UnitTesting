package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;
import luma.store.pages.CreateNewAccountPage;
import luma.store.pages.MyAccountPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationTest extends BaseTest {
    private CreateNewAccountPage createNewAccountPage;
    private MyAccountPage myAccountPage;

    @BeforeEach
    public void setUp() {
        createNewAccountPage = mainPage.openCreateAccountPage();
    }

    @Test
    @AllureId("AP-1")
    @Description("Verify the user ability to create an account with valid data")
    public void successUserRegistrationTest() {
        myAccountPage = createNewAccountPage.createAccount();
        assertTrue(myAccountPage.isSuccessRegistrationMessageDisplayed());
    }
}
