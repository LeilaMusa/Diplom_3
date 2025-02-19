package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String URL = "https://stellarburgers.nomoreparties.site/register";

    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorMessage = By.xpath("//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @Step("Открытие страницы регистрации")
    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

    @Step("Заполнение поля Имя")
    public void setName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
    }

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    @Step("Нажатие кнопки Зарегистрироваться")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    @Step("Получение текста ошибки")
    public String getErrorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}