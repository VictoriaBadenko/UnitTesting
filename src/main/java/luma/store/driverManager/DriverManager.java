package luma.store.driverManager;

import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static luma.store.helpers.Constants.BROWSER;
import static luma.store.helpers.Constants.REMOTE;
import static org.aspectj.bridge.MessageUtil.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriverInstance() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        MutableCapabilities capabilities = BrowserCapabilities.getBrowserCapabilities(BROWSER);
        if (!StringUtils.isNullOrEmpty(REMOTE)) {
            try {
                return new RemoteWebDriver(new URL(REMOTE), BrowserCapabilities.getCloudCapabilities(BROWSER, REMOTE));
            } catch (MalformedURLException exception) {
                throw new IllegalArgumentException("Invalid 'remote' parameter: " + REMOTE, exception);
            }
        }
        return getLocalDriver(capabilities);
    }

    private static WebDriver getLocalDriver(Capabilities capabilities) {
        switch (BROWSER) {
            case "chrome":
                return new ChromeDriver((ChromeOptions) Objects.requireNonNull(capabilities));
            case "firefox":
                return new FirefoxDriver((FirefoxOptions) Objects.requireNonNull(capabilities));
            default:
                fail("Local Driver: Your browser name is wrong!");
        }
        return null;
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
