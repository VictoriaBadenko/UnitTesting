package seleniumTest;

import org.testng.annotations.Test;
import yandex.mail.pages.MainPage;

import static org.testng.Assert.assertEquals;

public class YandexMailTest extends BaseTest {

    @Test
    public void testLoginToYandexMail() {
        var expectedTitle = "No messages in Inbox";
        var actualInboxTitle = new MainPage()
                .openWebSite()
                .openLoginPage()
                .inputUsername()
                .clickLogin()
                .inputPassword()
                .clickLogin()
                .getTitle();

        assertEquals(expectedTitle, actualInboxTitle, "Actual and expected title should be matched");
    }
}
