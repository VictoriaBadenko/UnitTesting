package seleniumTests.util;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static seleniumTests.util.BaseTest.browserInformation;
import static seleniumTests.util.BaseTest.screenshot;

public class AllureTestWatcher implements TestWatcher {

    private LocalDateTime dateTime = LocalDateTime.now();
    private String timeFormat = DateTimeFormatter.ofPattern("dd_MM_yyyy hh:mm:ss").format(dateTime);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (context.getExecutionException().isPresent()) {
            Allure.addAttachment("Date & Time", String.valueOf(timeFormat));
            Allure.addAttachment("Browser Information", browserInformation);
            Allure.addByteAttachmentAsync("Failed Screenshot", "image/png", () -> screenshot);
        }
    }
}
