package ru.praktikum.stellarburgers.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.praktikum.stellarburgers.api.UserClient;

public class ProfileTest extends BaseTest {

    private String email;
    private String password;

    @Before
    public void setUp() {
        super.setUp();

        String name = "User" + RandomStringUtils.randomAlphanumeric(5);
        email = "user" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
        password = RandomStringUtils.randomAlphanumeric(10);

        UserClient userClient = new UserClient();
        userClient.register(email, password, name);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
    }

    @Test
    public void testProfileAccess() {
        mainPage.clickPersonalAccount();
        assertTrue("Страница профиля должна быть отображена", profilePage.isDisplayed());
    }

    @Test
    public void testNavigationToConstructor() {
        mainPage.clickPersonalAccount();
        profilePage.clickConstructor();
        assertTrue("После перехода из профиля по кнопке конструктор должна открыться главная страница", mainPage.isDisplayed());
    }

    @Test
    public void testNavigationToConstructorViaLogo() {
        mainPage.clickPersonalAccount();
        profilePage.clickLogo();
        assertTrue("После перехода из профиля по логотипу должна открыться главная страница", mainPage.isDisplayed());
    }

    @Test
    public void testLogout() {
        mainPage.clickPersonalAccount();
        profilePage.clickLogout();
        assertTrue("После выхода из системы должна открыться страница логина", loginPage.isDisplayed());
    }
}