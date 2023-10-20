package yandex.mail.driverManager;

import org.openqa.selenium.Capabilities;
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
    private static WebDriver driver;
    private static final String USERNAME = "oauth-victoria.badenko.vb-002d6";
    private static final String ACCESS_KEY = "8a75ea0f-ff4a-4298-8945-37e5b5555e0f";
    public static final String SAUCE_LABS_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            try {
                driver = new RemoteWebDriver(new URL(SAUCE_LABS_URL), getRemoteInstance("edge"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static Capabilities getRemoteInstance(String environment) {
        switch (environment) {
            case "edge": {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName("Windows 10");
                edgeOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Win 10, Edge version: latest");
                sauceOptions.put("name", "Login & Logout Test");
                edgeOptions.setCapability("sauce:options", sauceOptions);
                return edgeOptions;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName("Windows 8.1");
                firefoxOptions.setBrowserVersion("39.0");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Win 8.1, Firefox version: 39.0");
                sauceOptions.put("name", "Login & logout mail test");
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                return firefoxOptions;
            }
            default: {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName("Linux");
                chromeOptions.setBrowserVersion("40");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Linux, Chrome version: 40");
                sauceOptions.put("name", "Login & logout mail test");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                return chromeOptions;
            }
        }
    }
}
