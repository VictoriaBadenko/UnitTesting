package seleniumTest;

import org.junit.jupiter.api.Test;
import yandex.mail.pages.MainPage;

public class YandexMailTest extends BaseTestRunner {

    @Test
    public void testLoginToYandexMail() {
        new MainPage()
                .openWebSite()
                .openLoginPage();
    }
}
