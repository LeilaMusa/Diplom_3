package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.config.WebDriverConfig;

public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector("#root > div > main > section.BurgerConstructor_basket__29Cd7.mt-25 > div > button");
    private final By personalAccountButton = By.cssSelector("#root > div > header > nav > a > p");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(WebDriverConfig.BASE_URL);
    }

    public void openLoginPage() {
        driver.get(WebDriverConfig.LOGIN_URL);
    }

    public void openRegisterPage() {
        driver.get(WebDriverConfig.REGISTER_URL);
    }

    public void clickLoginButton() {
        waitForElementClickable(loginButton).click();
    }

    public void clickPersonalAccount() {
        waitForElementClickable(personalAccountButton).click();
    }

    public boolean isDisplayed() {
        try {
            return waitForElementVisible(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}