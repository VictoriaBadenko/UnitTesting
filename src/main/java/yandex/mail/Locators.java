package yandex.mail;

import org.openqa.selenium.By;

public class Locators {
    public static final By LOG_IN_BUTTON = By.id("header-login-button");
    public static final By USERNAME_INPUT = By.id("passp-field-login");
    public static final By LOG_IN = By.id("passp:sign-in");
    public static final By PASSWORD_INPUT = By.name("passwd");
    public static final By INBOX_TITLE = By.xpath("//h1/span");
}
