package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import luma.store.pages.CreateNewAccountPage;
import luma.store.pages.MyAccountPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationTest extends BaseTest {
    private static CreateNewAccountPage createNewAccountPage;
    private MyAccountPage myAccountPage;

    @BeforeAll
    public static void setUp() {
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
