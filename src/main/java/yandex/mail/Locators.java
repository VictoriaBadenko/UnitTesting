package yandex.mail;

import org.openqa.selenium.By;

public class Locators {
    public static final By LOG_IN_BUTTON = By.id("header-login-button");
    public static final By USERNAME_INPUT = By.cssSelector("#passp-field-login");
    public static final By LOG_IN = By.id("passp:sign-in");
    public static final By LOG_IN_TO_MAIL = By.xpath("//button[contains(@class, 'Button2_type_submit')]");
    public static final By PASSWORD_INPUT = By.name("passwd");
    public static final By INBOX_TITLE = By.xpath("//h1/span");
    public static final By COMPOSE_BUTTON = By.cssSelector("a[href='#compose']");
    public static final By SEARCH_INPUT = By.className("textinput__control");
    public static final By IMAGE = By.tagName("img");
    public static final By LOG_OUT_LINK = By.linkText("Log out");
    public static final By COMPOSE_BU = By.partialLinkText("Attention!");
}
