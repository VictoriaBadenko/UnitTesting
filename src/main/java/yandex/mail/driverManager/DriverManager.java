package yandex.mail.driverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.ofSeconds;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String SELENIUM_GRID_URL = "http://localhost:4444/wd/hub";

    public DriverManager() {
    }

    public static WebDriver getDriverInstance() {
        if (driver.get() == null) {
            driver.set(setUpDriver());
        }
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    private static WebDriver setUpDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        URL url;
        try {
            url = new URL(SELENIUM_GRID_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        WebDriver webDriver = new RemoteWebDriver(url, capabilities);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        return webDriver;
    }
}
