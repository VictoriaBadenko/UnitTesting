package yandex.mail.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import yandex.mail.driverManager.DriverManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    private static final String PATH = "target/screenshots/";

    public static void makeScreenshot(String filePartName) {
        TakesScreenshot screenshot = ((TakesScreenshot) DriverManager.getDriverInstance());
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileWithPath = PATH + generateFileName(filePartName);
        File destFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateFileName(String filePartName) {
        LocalDateTime time = LocalDateTime.now();
        String timePrefix = DateTimeFormatter.ofPattern("yyyy_MM_dd").format(time);
        return "screenshot_" + filePartName + timePrefix + ".png";
    }
}
