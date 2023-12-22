package luma.store.driverManager;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.aspectj.bridge.MessageUtil.fail;

public class BrowserCapabilities {
    public static MutableCapabilities getBrowserCapabilities(String browser) {
        switch (browser) {
            case "chrome":
                return getChromeCapabilities();
            case "firefox":
                return getFirefoxCapabilities();
            default:
                fail("Browser Capabilities: Your browser name is wrong!");
        }
        return null;
    }

    private static MutableCapabilities getFirefoxCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("os", "Windows");
        return options;
    }

    private static MutableCapabilities getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("os", "Windows");
        return options;
    }

    public static MutableCapabilities getCloudCapabilities(String browser, String remote) {
        MutableCapabilities capabilities = getBrowserCapabilities(browser);
        Objects.requireNonNull(capabilities).setCapability("platformName", "Windows 10");
        if (remote.contains("saucelabs.com")) {
            capabilities.setCapability("browserVersion", "latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("build", "Final task build");
            sauceOptions.put("name", "Final test");
            capabilities.setCapability("sauce:options", sauceOptions);
        }
        return capabilities;
    }
}
