package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private final By logoutButton = By.cssSelector("#root > div > main > div > nav > ul > li:nth-child(3) > button");
    private final By constructorLink = By.cssSelector("#root > div > header > nav > ul > li:nth-child(1) > a > p");
    private final By logo = By.cssSelector("#root > div > header > nav > div > a > svg");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        try {
            return waitForElementVisible(logoutButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        scrollToElement(logoutButton);
        waitForElementClickable(logoutButton).click();
    }

    public void clickConstructor() {
        scrollToElement(constructorLink);
        waitForElementClickable(constructorLink).click();
    }

    public void clickLogo() {
        scrollToElement(logo);
        waitForElementClickable(logo).click();
    }
}