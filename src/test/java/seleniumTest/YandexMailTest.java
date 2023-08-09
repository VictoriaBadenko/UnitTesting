package seleniumTest;

import org.testng.annotations.Test;
import yandex.mail.pages.MainPage;

import static org.testng.Assert.assertTrue;

public class YandexMailTest extends BaseTest {
    public static final String USER_NAME = "testuserte5t";
    public static final String PASSWORD = "Test951X";

    @Test
    public void testLoginToYandexMail() {
        var isMailOpened = new MainPage()
                .openWebSite()
                .openLoginPage()
                .inputUsername(USER_NAME)
                .clickLogin()
                .inputPassword(PASSWORD)
                .clickLoginToMail()
                .isMailContainerDisplayed();

        assertTrue(isMailOpened, "Yandex Mail Inbox page should be displayed");
    }
}
