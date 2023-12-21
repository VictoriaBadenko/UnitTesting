package luma.store.driverManager;

import io.opentelemetry.api.internal.StringUtils;
import luma.store.helpers.Constants;
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

import static org.aspectj.bridge.MessageUtil.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String USERNAME = "oauth-victoria.badenko.vb-002d6";
    private static final String ACCESS_KEY = "8a75ea0f-ff4a-4298-8945-37e5b5555e0f";
    public static final String SAUCE_LABS_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    private DriverManager() {
    }

    public static WebDriver getDriverInstance() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    private static WebDriver createDriver() {
        MutableCapabilities capabilities = BrowserCapabilities.getBrowserCapabilities(Constants.BROWSER);
        if (!StringUtils.isNullOrEmpty(Constants.REMOTE)) {
            try {
                return new RemoteWebDriver(new URL(Constants.REMOTE), BrowserCapabilities.getCloudCapabilities(Constants.BROWSER, Constants.REMOTE));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Invalid 'remote' parameter: " + Constants.REMOTE, e);
            }
        }
        return getLocalDriver(capabilities);
    }

    private static WebDriver getLocalDriver(Capabilities capabilities) {
        switch (Constants.BROWSER) {
            case "chrome":
                return new ChromeDriver((ChromeOptions) Objects.requireNonNull(capabilities));
            case "firefox":
                return new FirefoxDriver((FirefoxOptions) Objects.requireNonNull(capabilities));
            default:
                fail("getLocalDriver: Please check your browser name");
        }
        return null;
    }
}
