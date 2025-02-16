package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By emailField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(1) > div > div > input");
    private final By passwordField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(2) > div > div > input");
    private final By loginButton = By.cssSelector("#root > div > main > div > form > button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        // Заполнение поля Email
        WebElement emailInput = waitForElementVisible(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        // Заполнение поля Password
        WebElement passwordInput = waitForElementVisible(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        // Клик по кнопке "Войти"
        waitForElementClickable(loginButton).click();
    }

    public void clickRegisterLink() {
        waitForElementClickable(By.cssSelector("a[href=\"/register\"]")).click();
    }

    public boolean isDisplayed() {
        try {
            return waitForElementVisible(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}