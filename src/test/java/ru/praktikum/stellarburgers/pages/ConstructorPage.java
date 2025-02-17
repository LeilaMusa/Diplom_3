package ru.praktikum.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {
    private final By bunsTab = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > h2:nth-child(1)");
    private final By saucesTab = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > h2:nth-child(3)");
    private final By fillingsTab = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > h2:nth-child(5)");

    private final By bunsSection = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(3) > ul");
    private final By saucesSection = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(4) > ul");
    private final By fillingsSection = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(5) > ul");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public void clickBunsTab() {
        scrollToElement(saucesTab); // Прокрутка до Соусов
        scrollToElement(bunsTab); // Прокрутка до Булок
        waitForElementClickable(bunsTab).click();
        waitForElementVisible(bunsSection);
    }

    public void clickSaucesTab() {
        scrollToElement(fillingsTab); // Прокрутка до Начинок
        scrollToElement(saucesTab); // Прокрутка до Соусов
        waitForElementClickable(saucesTab).click();
        waitForElementVisible(saucesSection);
    }

    public void clickFillingsTab() {
        scrollToElement(fillingsTab); // Прокрутка до Начинок
        waitForElementClickable(fillingsTab).click();
        waitForElementVisible(fillingsSection);
    }

    public boolean isBunsSectionDisplayed() {
        return waitForElementVisible(bunsSection).isDisplayed();
    }

    public boolean isSaucesSectionDisplayed() {
        return waitForElementVisible(saucesSection).isDisplayed();
    }

    public boolean isFillingsSectionDisplayed() {
        return waitForElementVisible(fillingsSection).isDisplayed();
    }
}