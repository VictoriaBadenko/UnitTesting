package yandex.mail.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String USERNAME = "oauth-victoria.badenko.vb-002d6";
    private static final String ACCESS_KEY = "8a75ea0f-ff4a-4298-8945-37e5b5555e0f";
    public static final String SAUCE_LABS_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private static final String ENVIRONMENT = "chrome";

    public DriverManager() {
    }

    public static WebDriver getDriverInstance() {
        if (driver.get() == null) {
            driver.set(getRemoteInstance(ENVIRONMENT));
        }
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    private static RemoteWebDriver getRemoteInstance(String environment) {
        URL url;
        try {
            url = new URL(SAUCE_LABS_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> sauceOptions = new HashMap<>();

        switch (environment) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName("Windows 10");
                edgeOptions.setBrowserVersion("latest");
                sauceOptions.put("build", "Win 10, Edge version: latest");
                sauceOptions.put("name", "Login & Logout Test");
                edgeOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(url, edgeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName("Windows 8.1");
                firefoxOptions.setBrowserVersion("39.0");
                sauceOptions.put("build", "Win 8.1, Firefox version: 39.0");
                sauceOptions.put("name", "Login & logout mail test");
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(url, firefoxOptions);
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName("Linux");
                chromeOptions.setBrowserVersion("40");
                sauceOptions.put("build", "Linux, Chrome version: 40");
                sauceOptions.put("name", "Login & logout mail test");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(url, chromeOptions);
        }
    }
}
