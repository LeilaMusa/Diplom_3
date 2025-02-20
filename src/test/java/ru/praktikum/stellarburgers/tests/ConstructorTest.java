package ru.praktikum.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.stellarburgers.config.WebDriverConfig;
import ru.praktikum.stellarburgers.pages.ConstructorPage;
import ru.praktikum.stellarburgers.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    private MainPage mainPage;
    private ConstructorPage constructorPage;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        driver = WebDriverConfig.createDriver();
        mainPage = new MainPage(driver);
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу 'Булки' через 'Соусы'")
    @Description("Проверка перехода к разделу 'Булки' после перехода на 'Соусы'")
    public void switchToBunsTest() {
        mainPage.open();
        constructorPage.clickSaucesSection();
        assertTrue("Раздел 'Соусы' не активен", constructorPage.isSaucesSectionActive());

        constructorPage.clickBunsSection();
        assertTrue("Раздел 'Булки' не активен", constructorPage.isBunsSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' в конструкторе")
    public void switchToSaucesTest() {
        mainPage.open();
        constructorPage.clickSaucesSection();
        assertTrue("Раздел 'Соусы' не активен", constructorPage.isSaucesSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' в конструкторе")
    public void switchToFillingsTest() {
        mainPage.open();
        constructorPage.clickSaucesSection();
        constructorPage.clickFillingsSection();
        assertTrue("Раздел 'Начинки' не активен", constructorPage.isFillingsSectionActive());
    }
}