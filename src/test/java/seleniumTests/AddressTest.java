package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import luma.store.pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;

import static luma.store.helpers.Constants.EMAIL;
import static luma.store.helpers.Constants.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest extends BaseTest {
    private static HomePage homePage;

    @BeforeAll
    public static void login() {
        homePage = mainPage.clickSignIn().login(EMAIL, PASSWORD);
    }

    @Test
    @AllureId("AP-3")
    @Description("Verify the user ability to add address")
    public void testAddNewAddress() {
        var isAddressSaved = homePage
                .clickMyAccountButton()
                .clickAddressBookMenuTab()
                .addNewAddress()
                .isAddressSavedMessageDisplayed();
        assertTrue(isAddressSaved);
    }

    @AfterAll
    public static void cleanUp() {
        homePage
                .clickMyAccountButton()
                .clickAddressBookMenuTab()
                .deleteAddress();
    }
}
