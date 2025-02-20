package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By profileLink = By.xpath("//a[@href='/account/profile']");
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");
    private final By logoLink = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @Step("Открытие страницы профиля")
    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }

    @Step("Выход из аккаунта")
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        // Ждем редиректа на страницу логина
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    @Step("Проверка отображения профиля")
    public boolean isProfileDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Переход в конструктор")
    public void clickConstructor() {
        wait.until(ExpectedConditions.elementToBeClickable(constructorLink)).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logoLink)).click();
    }
}