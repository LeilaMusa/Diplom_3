package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By restorePasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    private final By errorText = By.xpath("//p[contains(text(), 'Некорректный пароль')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    @Step("Заполнение поля Password")
    public void setPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    @Step("Нажатие кнопки Войти")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Выполнение входа с ожиданием перехода на главную страницу")
    public void loginWithRedirect(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    @Step("Выполнение входа и возврат текущего URL")
    public String login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        return driver.getCurrentUrl();
    }

    @Step("Клик по ссылке регистрации")
    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    @Step("Клик по ссылке восстановления пароля")
    public void clickRestorePasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(restorePasswordLink)).click();
    }

    @Step("Получение текста ошибки")
    public String getErrorText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorText)).getText();
    }

    @Step("Проверка отображения кнопки 'Войти'")
    public boolean isLoginButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}