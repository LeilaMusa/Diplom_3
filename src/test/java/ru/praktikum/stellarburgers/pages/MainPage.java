package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    // Локаторы
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    // Локаторы табов
    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    @Step("Нажатие на 'Конструктор'")
    public void clickConstructor() {
        wait.until(ExpectedConditions.elementToBeClickable(constructorButton)).click();
    }

    @Step("Переключение на таб 'Булки'")
    public void clickBunsTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(bunsTab));
        tab.click();
        wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
    }

    @Step("Переключение на таб 'Соусы'")
    public void clickSaucesTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(saucesTab));
        tab.click();
        wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
    }

    @Step("Переключение на таб 'Начинки'")
    public void clickFillingsTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(fillingsTab));
        tab.click();
        wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
    }

    @Step("Проверка видимости кнопки 'Войти в аккаунт'")
    public boolean isLoginButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}