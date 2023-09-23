package seleniumTest;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static seleniumTest.BaseTest.browserInformation;
import static seleniumTest.BaseTest.screenshot;

public class AllureTestWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (context.getExecutionException().isPresent()) {
            Allure.addAttachment("Browser Information", browserInformation);
            Allure.addByteAttachmentAsync("Failed Screenshot", "image/png", () -> screenshot);
        }
    }
}
