package seleniumTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import yandex.mail.pages.MainPage;

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

        Assertions.assertEquals(expectedTitle, actualInboxTitle, "Actual and expected title should be matched");
    }
}
