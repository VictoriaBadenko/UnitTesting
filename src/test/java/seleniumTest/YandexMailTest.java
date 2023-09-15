package seleniumTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yandex.mail.pages.InboxPage;
import yandex.mail.pages.MainPage;
import yandex.mail.screenshot.ScreenshotHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexMailTest extends BaseTest {

    private static final String USERNAME = "testuserte5t";
    private static final String PASSWORD = "Test951X";

    private InboxPage inboxPage;
    private MainPage mainPage;

    @BeforeEach
    public void loginToYandex() {
        mainPage = new MainPage().openWebSite();
        ScreenshotHelper.makeScreenshot("loginToYandex_" + "HomePage_");
        mainPage
                .openLoginPage()
                .loginToYandexMail(USERNAME, PASSWORD);
        inboxPage = new InboxPage();
    }

    @Test
    public void testLoginToYandexMail() {
        var isMailOpened = inboxPage
                .isMailContainerDisplayed();

        assertTrue(isMailOpened, "Yandex Mail Inbox page should be displayed");
    }

    @Test
    public void testLogoutFromYandexMail() {
        var isLogout = inboxPage
                .clickLogOut()
                .isLoginButtonDisplayed();

        assertTrue(isLogout, "Yandex Main page should be displayed after logout");
    }
}
