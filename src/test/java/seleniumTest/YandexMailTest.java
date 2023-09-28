package seleniumTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yandex.mail.pages.InboxPage;
import yandex.mail.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexMailTest extends BaseTest {

    private static final String USERNAME = "testuserte5t";
    private static final String PASSWORD = "Test951X";

    private InboxPage inboxPage;

    @BeforeEach
    public void loginToYandex() {
        new MainPage()
                .openWebSite()
                .openLoginPage()
                .loginToYandexMail(USERNAME, PASSWORD);
        inboxPage = new InboxPage();
    }

    @Feature("Login group")
    @Test
    @TmsLink("T1")
    @Description("Verify that user can successfully login to yandex mail")
    public void testLoginToYandexMail() {
        var isMailOpened = inboxPage
                .isMailContainerDisplayed();

        assertTrue(isMailOpened, "Yandex Mail Inbox page should be displayed");
    }

    @Feature("Logout group")
    @Test
    @TmsLink("T2")
    @Description("Verify that user can successfully log out from yandex mail")
    public void testLogoutFromYandexMail() {
        var isLogout = inboxPage
                .clickLogOut()
                .isLoginButtonDisplayed();

        assertTrue(isLogout, "Yandex Main page should be displayed after logout");
    }
}
