package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By nameField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(1) > div > div > input");
    private final By emailField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(2) > div > div > input");
    private final By passwordField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(3) > div > div > input");
    private final By registerButton = By.cssSelector("#root > div > main > div > form > button");
    private final By passwordError = By.cssSelector(".input__error.text_type_main-default");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String name, String email, String password) {
        // Заполнение поля "Имя"
        WebElement nameInput = waitForElementVisible(nameField);
        nameInput.clear();
        nameInput.sendKeys(name);

        // Заполнение поля "Email"
        WebElement emailInput = waitForElementVisible(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        // Заполнение поля "Пароль"
        WebElement passwordInput = waitForElementVisible(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        // Клик по кнопке "Зарегистрироваться"
        waitForElementClickable(registerButton).click();
    }

    public String getPasswordError() {
        // Ожидание появления сообщения об ошибке
        return waitForElementVisible(passwordError).getText();
    }
}