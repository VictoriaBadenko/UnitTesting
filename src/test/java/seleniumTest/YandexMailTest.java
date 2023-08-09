package seleniumTest;

import org.testng.annotations.Test;
import yandex.mail.pages.MainPage;

import static org.testng.Assert.assertEquals;

public class YandexMailTest extends BaseTest {
    public static final String USER_NAME = "testuserte5t";
    public static final String PASSWORD = "Test951X";

    @Test
    public void testLoginToYandexMail() {
        var expectedTitle = "No messages in Inbox";
        var actualInboxTitle = new MainPage()
                .openWebSite()
                .openLoginPage()
                .inputUsername(USER_NAME)
                .clickLogin()
                .inputPassword(PASSWORD)
                .clickLoginToMail()
                .getTitle();

        assertEquals(actualInboxTitle, expectedTitle,"Actual and expected title should be matched");
    }
}
