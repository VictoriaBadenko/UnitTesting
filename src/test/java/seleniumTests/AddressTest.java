package seleniumTests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seleniumTests.util.BaseTest;
import luma.store.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static luma.store.helpers.Constants.EMAIL;
import static luma.store.helpers.Constants.PASSWORD;

public class AddressTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    public void login() {
        homePage = mainPage.clickSignIn().login(EMAIL, PASSWORD);
    }

    @Test
    @AllureId("AP-3")
    @Description("Verify the user ability to add address")
    public void addNewAddressTest() {
        var isAddressSaved = homePage
                .clickMyAccountButton()
                .clickAddressBookMenuTab()
                .addNewAddress()
                .isAddressSavedMessageDisplayed();
        assertTrue(isAddressSaved);
    }

    @AfterEach
    public void cleanUp() {
        homePage
                .clickMyAccountButton()
                .clickAddressBookMenuTab()
                .deleteAddress();
    }
}
