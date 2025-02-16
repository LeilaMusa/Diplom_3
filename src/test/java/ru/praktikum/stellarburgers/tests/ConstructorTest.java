package ru.praktikum.stellarburgers.tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructorTest extends BaseTest {

    @Test
    public void testBunsTab() {
        mainPage.open();
        constructorPage.clickSaucesTab(); // Переход на Соусы
        constructorPage.clickBunsTab(); // Переход на Булки
        assertTrue("Раздел 'Булки' должен отображаться", constructorPage.isBunsSectionDisplayed());
    }

    @Test
    public void testSaucesTab() {
        mainPage.open();
        constructorPage.clickFillingsTab(); // Переход на Начинки
        constructorPage.clickSaucesTab(); // Переход на Соусы
        assertTrue("Раздел 'Соусы' должен отображаться", constructorPage.isSaucesSectionDisplayed());
    }

    @Test
    public void testFillingsTab() {
        mainPage.open();
        constructorPage.clickFillingsTab();
        assertTrue("Раздел 'Начинки' должен отображаться", constructorPage.isFillingsSectionDisplayed());
    }
}