package seleniumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import yandex.mail.pages.MainPage;

import static org.testng.Assert.assertTrue;

public class YandexMailTest extends BaseTest {

    @DataProvider(name = "credentialsProvider")
    public Object[][] credentialsProvider() {
        return new Object[][]{
                {"testuserte5t", "Test951X"},
                {"testuser2test", "Test123R"}
        };
    }

    @Test(dataProvider = "credentialsProvider")
    public void testLoginToYandexMail(String username, String password) throws InterruptedException {
        var inboxPage = new MainPage()
                .openWebSite()
                .openLoginPage()
                .inputUsername(username)
                .clickLogin()
                .inputPassword(password)
                .clickLoginToMail();

        // Adding a Thread.sleep (not recommended).
        // This is a static wait, and it doesn't consider the actual state of the application.
        Thread.sleep(5000);

        assertTrue(inboxPage.isMailContainerDisplayed(), "Yandex Mail Inbox page should be displayed");
    }
}
