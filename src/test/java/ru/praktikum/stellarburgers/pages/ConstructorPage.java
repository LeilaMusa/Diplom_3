package ru.praktikum.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы для разделов
    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Булки']/parent::div")
    private WebElement bunsSection;

    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Соусы']/parent::div")
    private WebElement saucesSection;

    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Начинки']/parent::div")
    private WebElement fillingsSection;

    // Локаторы для продуктов из разделов
    @FindBy(xpath = "//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Флюоресцентная булка R2-D3']")
    private WebElement bunProduct;

    @FindBy(xpath = "//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Соус Spicy-X']")
    private WebElement sauceProduct;

    @FindBy(xpath = "//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Мясо бессмертных моллюсков Protostomia']")
    private WebElement fillingProduct;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка активности раздела 'Булки'")
    public boolean isBunsSectionActive() {
        wait.until(ExpectedConditions.visibilityOf(bunProduct));
        return bunProduct.isDisplayed();
    }

    @Step("Проверка активности раздела 'Соусы'")
    public boolean isSaucesSectionActive() {
        wait.until(ExpectedConditions.visibilityOf(sauceProduct));
        return sauceProduct.isDisplayed();
    }

    @Step("Проверка активности раздела 'Начинки'")
    public boolean isFillingsSectionActive() {
        wait.until(ExpectedConditions.visibilityOf(fillingProduct));
        return fillingProduct.isDisplayed();
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBunsSection() {
        scrollToElement(bunsSection);
        wait.until(ExpectedConditions.elementToBeClickable(bunsSection)).click();
        wait.until(ExpectedConditions.visibilityOf(bunProduct)); // Ожидаем отображение продукта
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSaucesSection() {
        scrollToElement(saucesSection);
        wait.until(ExpectedConditions.elementToBeClickable(saucesSection)).click();
        wait.until(ExpectedConditions.visibilityOf(sauceProduct)); // Ожидаем отображение продукта
    }

    @Step("Клик по разделу 'Начинки'")
    public void clickFillingsSection() {
        scrollToElement(fillingsSection);
        wait.until(ExpectedConditions.elementToBeClickable(fillingsSection)).click();
        wait.until(ExpectedConditions.visibilityOf(fillingProduct)); // Ожидаем отображение продукта
    }

    @Step("Прокрутка к элементу")
    private void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Небольшая задержка для стабилизации прокрутки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}